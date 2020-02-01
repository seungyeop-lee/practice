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
	fmt.Printf("Received Sum RPC: %v\n", req)
	firstNum := req.GetFirst()
	secondNum := req.GetSecond()
	log.Printf("first is %v and second is %v", firstNum, secondNum)

	sum := firstNum + secondNum
	res := &calculatorpb.SumResponse{
		Result: sum,
	}
	return res, nil
}

func (*server) Decompose(req *calculatorpb.DecomposeRequest, stream calculatorpb.CalService_DecomposeServer) error {
	fmt.Printf("Received Decompose RPC: %v\n", req)
	number := req.GetNumber()
	var divisor int64 = 2
	for number > 1 {
		if number%divisor == 0 {
			stream.Send(&calculatorpb.DecomposeResponse{
				PrimeFactor: divisor,
			})
			number = number / divisor
		} else {
			divisor++
			fmt.Printf("Divisor has increased to %v\n", divisor)
		}
	}
	return nil
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
