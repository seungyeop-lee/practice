package main

import (
	"context"
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
	doDecompose(c)
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
