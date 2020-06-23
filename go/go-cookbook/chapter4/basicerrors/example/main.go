package main

import (
	"chapter4/basicerrors"
	"fmt"
)

func main() {
	basicerrors.BasicErrors()

	err := basicerrors.SomeFunc()
	fmt.Println("custom error: ", err)
}
