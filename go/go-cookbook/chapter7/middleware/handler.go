package middleware

import "net/http"

//Handler 매우 기본적인 핸들러이다.
func Handler(w http.ResponseWriter, r *http.Request) {
	w.WriteHeader(http.StatusOK)
	w.Write([]byte("success"))
}
