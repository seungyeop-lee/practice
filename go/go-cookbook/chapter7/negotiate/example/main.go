package main

import (
	"chapter7/negotiate"
	"fmt"
	"net/http"
)

func main() {
	http.HandleFunc("/", negotiate.Handler)
	fmt.Println("Listening on port : 3333")
	err := http.ListenAndServe(":3333", nil)
	panic(err)
}
