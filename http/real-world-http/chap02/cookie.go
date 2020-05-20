package main

import (
	"fmt"
	"log"
	"net/http"
)

func cookieHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Add("Set-Cookie", "VISIT=TRUE")

	if _, ok := r.Header["Cookie"]; ok {
		fmt.Fprintf(w, "<html><body>두 번째 이후</html></body>\n")
	} else {
		fmt.Fprintf(w, "<html><body>첫 방문</html></body>\n")
	}
}

func main() {
	var httpServer http.Server
	http.HandleFunc("/", cookieHandler)
	log.Println("start http listening :18888")
	httpServer.Addr = ":18888"
	log.Println(httpServer.ListenAndServe())
}
