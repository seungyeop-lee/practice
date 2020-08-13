package main

import (
	"chapter7/proxy"
	"fmt"
	"net/http"
)

func main() {
	p := &proxy.Proxy{
		Client:  http.DefaultClient,
		BaseURL: "https://www.golang.org",
	}
	http.Handle("/", p)
	fmt.Println("Listening on port :3333")
	err := http.ListenAndServe(":3333", nil)
	panic(err)
}
