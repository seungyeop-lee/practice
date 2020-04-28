package main

import (
	"bytes"
	"fmt"
	"io"
	"os"
)

func main() {
	var b bytes.Buffer

	b.Write([]byte("안녕하세요"))

	fmt.Fprintf(&b, "Go in action!")

	io.Copy(os.Stdout, &b)
}
