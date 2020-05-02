package main

import (
	"log"
)

func init() {
	log.SetPrefix("추적: ")
	log.SetFlags(log.Ldate | log.Lmicroseconds | log.Llongfile)
}

func main() {
	log.Println("메시지")

	log.Fatalln("치명적 오류 메시지")

	log.Panicln("패닉 메시지")
}
