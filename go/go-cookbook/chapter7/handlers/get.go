package handlers

import (
	"fmt"
	"net/http"
)

//HelloHandler 는 GET 매개변수로 "name"을 받아서
//일반 문장(pain text)으로 Hello <name>!라고 응답한다.
func HelloHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "text/plain")
	if r.Method != http.MethodGet {
		w.WriteHeader(http.StatusMethodNotAllowed)
		return
	}
	name := r.URL.Query().Get("name")

	w.WriteHeader(http.StatusOK)
	w.Write([]byte(fmt.Sprintf("Hello %s!", name)))
}
