package main

import (
	"context"
	"fmt"
	"google.golang.org/grpc"
	"grpc-hands-on/calculator/calculatorpb"
	"io"
	"log"
)

func main() {
	cc, err := grpc.Dial(":50051", grpc.WithInsecure())
	if err != nil {
		log.Fatalf("Failed to connect: %v", err)
	}
	defer cc.Close()

	c := calculatorpb.NewCalServiceClient(cc)

	//doSum(c)
	//doDecompose(c)
	doClientStreaming(c)
}

func doSum(c calculatorpb.CalServiceClient) {
	req := &calculatorpb.SumRequest{
		First:  3,
		Second: 10,
	}
	res, err := c.Sum(context.Background(), req)
	if err != nil {
		log.Fatalf("error while calling Sum RPC: %v", err)
	}

	log.Printf("Response from Sum: %v", res.Result)
}

func doDecompose(c calculatorpb.CalServiceClient) {
	req := &calculatorpb.DecomposeRequest{
		Number: 120,
	}
	stream, err := c.Decompose(context.Background(), req)
	if err != nil {
		log.Fatalf("error while calling Decompose RPC: %v", err)
	}

	for {
		res, err := stream.Recv()
		if err == io.EOF {
			break
		}
		if err != nil {
			log.Fatalf("error while reading stream: %v", err)
		}
		log.Println(res.PrimeFactor)
	}
}

func doClientStreaming(c calculatorpb.CalServiceClient) {
	stream, err := c.ComputeAverage(context.Background())
	if err != nil {
		log.Fatalf("error while opening stream: %v", err)
	}

	numbers := []int32{3, 5, 9, 54, 23}

	for _, number := range numbers {
		fmt.Printf("Sending number: %v\n", number)
		stream.Send(&calculatorpb.ComputeAverageRequest{
			Number: number,
		})
	}

	res, err := stream.CloseAndRecv()
	if err != nil {
		log.Fatalf("Error while receiving response: %v", err)
	}

	fmt.Printf("The Average is: %v", res.GetAverage())

}
