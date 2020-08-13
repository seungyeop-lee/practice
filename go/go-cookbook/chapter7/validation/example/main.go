package main

import (
	"chapter7/validation"
	"fmt"
	"net/http"
)

func main() {
	c := validation.New()
	http.HandleFunc("/", c.Process)
	fmt.Println("Listening on port :3333")

	err := http.ListenAndServe(":3333", nil)
	panic(err)
}
