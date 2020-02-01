package main

import (
	"context"
	"fmt"
	"google.golang.org/grpc"
	"grpc-hands-on/calculator/calculatorpb"
	"log"
	"net"
)

type server struct{}

func (*server) Sum(con context.Context, req *calculatorpb.SumRequest) (*calculatorpb.SumResponse, error) {
	firstNum := req.GetFirst()
	secondNum := req.GetSecond()
	log.Printf("first is %v and second is %v", firstNum, secondNum)

	sum := firstNum + secondNum
	res := &calculatorpb.SumResponse{
		Result: sum,
	}
	return res, nil
}

func main() {
	fmt.Println("Calculator Server")

	lis, err := net.Listen("tcp", "0.0.0.0:50051")
	if err != nil {
		log.Fatalf("Failed to listen: %v", err)
	}

	s := grpc.NewServer()
	calculatorpb.RegisterCalServiceServer(s, &server{})

	fmt.Println("Start to listen")
	if err := s.Serve(lis); err != nil {
		log.Fatalf("Failed to serve: %v", err)
	}
}
