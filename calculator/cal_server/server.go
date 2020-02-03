package main

import (
	"context"
	"fmt"
	"google.golang.org/grpc"
	"grpc-hands-on/calculator/calculatorpb"
	"io"
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

func (*server) ComputeAverage(stream calculatorpb.CalService_ComputeAverageServer) error {
	fmt.Printf("Received ComputeAverage RPC\n")

	sum := int32(0)
	count := 0

	for {
		req, err := stream.Recv()
		if err == io.EOF {
			average := float64(sum) / float64(count)
			return stream.SendAndClose(&calculatorpb.ComputeAverageResponse{
				Average: average,
			})
		}
		if err != nil {
			log.Fatalf("Error while reading client stream: %v", err)
		}
		sum += req.GetNumber()
		count++
	}
}

func (*server) FindMaximum(stream calculatorpb.CalService_FindMaximumServer) error {
	fmt.Printf("Received FindMaximum RPC\n")
	maximum := int32(0)

	for {
		req, err := stream.Recv()
		if err == io.EOF {
			return nil
		}
		if err != nil {
			log.Fatalf("Error while reading client stream: %v", err)
			return err
		}
		number := req.GetNumber()
		if number > maximum {
			maximum = number
			sendErr := stream.Send(&calculatorpb.FindMaximumResponse{
				Maximum: maximum,
			})
			if sendErr != nil {
				log.Fatalf("Error while sending data to client: %v", err)
				return err
			}
		}
	}
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
