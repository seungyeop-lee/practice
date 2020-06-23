package main

import (
	"chapter3/math"
	"fmt"
)

func main() {
	math.Examples()

	for i := 0; i < 100; i++ {
		fmt.Printf("%v ", math.Fib(i))
	}
	fmt.Println()
}
