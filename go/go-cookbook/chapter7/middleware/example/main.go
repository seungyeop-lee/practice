package main

import (
	"chapter7/middleware"
	"fmt"
	"log"
	"net/http"
	"os"
)

func main() {
	//아래에서부터 위로 적용된다.
	h := middleware.ApplyMiddleware(
		middleware.Handler,
		middleware.Logger(log.New(os.Stdout, "", 0)),
		middleware.SetID(100),
	)
	http.HandleFunc("/", h)
	fmt.Println("Listening on port :3333")
	err := http.ListenAndServe(":3333", nil)
	panic(err)
}
