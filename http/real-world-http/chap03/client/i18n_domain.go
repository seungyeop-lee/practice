package main

import (
	"fmt"
	"golang.org/x/net/idna"
	"net/http"
)

func main() {
	src := "악력왕"
	ascii, err := idna.ToASCII(src)
	if err != nil {
		panic(err)
	}
	fmt.Printf("%s -> %s\n", src, ascii)

	unicode, err := idna.ToUnicode(src)
	if err != nil {
		panic(err)
	}
	fmt.Printf("%s -> %s\n", src, unicode)
}
