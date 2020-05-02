package main

import (
	"listing17/handlers"
	"log"
	"net/http"
)

func main() {
	handlers.Routes()

	log.Println("웹 서비스 실행 중: 포트: 4000")
	http.ListenAndServe(":4000", nil)
}
