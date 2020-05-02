package main

import (
	"bytes"
	"fmt"
	"os"
)

func main() {
	var b bytes.Buffer
	b.Write([]byte("안녕하세요 "))

	fmt.Fprintf(&b, "Golang!")

	b.WriteTo(os.Stdout)
}
