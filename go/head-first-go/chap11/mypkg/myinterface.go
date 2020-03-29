package mypkg

import "fmt"

type MyInterface interface {
	MethodWithoutParameters()
	MethodWithParameter(float64)
	MethodWithReturnValue() string
}

type MyTape int

func (m MyTape) MethodWithoutParameters() {
	fmt.Println("MethodWithoutParameters called")
}

func (m MyTape) MethodWithParameter(float64) {
	fmt.Println("MethodWithParameter called with", false)
}

func (m MyTape) MethodWithReturnValue() string {
	return "Hi from MethodWithReturnValue"
}

func (m MyTape) MethodNoInInterface() {
	fmt.Println("MethodNoInInterface called")
}
