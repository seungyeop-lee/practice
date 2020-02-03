package main

import (
	"context"
	"fmt"
	"google.golang.org/grpc"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/status"
	"grpc-hands-on/calculator/calculatorpb"
	"io"
	"log"
	"time"
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
	//doClientStreaming(c)
	//doBiDiStreaming(c)
	doErrorUnary(c)
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

func doBiDiStreaming(c calculatorpb.CalServiceClient) {
	stream, err := c.FindMaximum(context.Background())
	if err != nil {
		log.Fatalf("Error while opening stream and calling FindMaximum: %v", err)
	}

	waitc := make(chan struct{})

	// send go routine
	go func() {
		numbers := []int32{4, 7, 2, 19, 4, 6, 32}
		for _, number := range numbers {
			fmt.Printf("Sending number: %v\n", number)
			stream.Send(&calculatorpb.FindMaximumRequest{
				Number: number,
			})
			time.Sleep(time.Second)
		}
		stream.CloseSend()
	}()

	// receive go routine
	go func() {
		for {
			res, err := stream.Recv()
			if err == io.EOF {
				break
			}
			if err != nil {
				log.Fatalf("Problem while reading server stream: %v", err)
				break
			}
			maximum := res.GetMaximum()
			fmt.Printf("Received a new maximum of...: %v\n", maximum)
		}
		close(waitc)
	}()
	<-waitc
}

func doErrorUnary(c calculatorpb.CalServiceClient) {
	fmt.Printf("Starting to do a SquareRoot Unary RPC...\n")

	// correct call
	doErrorCall(c, 10)

	//error call
	doErrorCall(c, -2)
}

func doErrorCall(c calculatorpb.CalServiceClient, n int32) {
	number := n
	res, err := c.SquareRoot(context.Background(), &calculatorpb.SquareRootRequest{
		Number: number,
	})
	if err != nil {
		respErr, ok := status.FromError(err)
		if ok {
			// actual error from gRPC(user error)
			fmt.Printf("Error message from server: %v\n", respErr.Message())
			fmt.Println(respErr.Code())
			if respErr.Code() == codes.InvalidArgument {
				fmt.Println("We probably sent a negative number!")
				return
			}
		} else {
			log.Fatalf("Big Error calling SquareRoot: %v", err)
			return
		}
	}
	fmt.Printf("Result of square root of %v: %v\n", number, res.GetNumberRoot())
}