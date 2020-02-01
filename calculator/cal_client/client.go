package main

import (
	"context"
	"google.golang.org/grpc"
	"grpc-hands-on/calculator/calculatorpb"
	"log"
)

func main() {
	cc, err := grpc.Dial(":50051", grpc.WithInsecure())
	if err != nil {
		log.Fatalf("Failed to connect: %v", err)
	}
	defer cc.Close()

	c := calculatorpb.NewCalServiceClient(cc)
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
