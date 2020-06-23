package main

import (
	"chapter3/tags"
	"fmt"
)

func main() {
	if err := tags.EmptyStruct(); err != nil {
		panic(err)
	}

	fmt.Println()

	if err := tags.FullStruct(); err != nil {
		panic(err)
	}
}
