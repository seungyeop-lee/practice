package handlers

import (
	"encoding/json"
	"net/http"
)

//GreetingResponse 는 GreetingHandler 가
//리턴한 값의 JSON 응답니다.
type GreetingResponse struct {
	Payload struct {
		Greeting string `json:"greeting,omitempty"`
		Name     string `json:"name,omitempty"`
		Error    string `json:"error,omitempty"`
	} `json:"payload"`
	Successful bool `json:"successful"`
}

//GreetingHandler 는 에러나 유효한 페이로드(payload) 중
//하나를 갖고 있는 GreetingResponse 를 반환한다.
func GreetingHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	if r.Method != http.MethodPost {
		w.WriteHeader(http.StatusMethodNotAllowed)
		return
	}
	var gr GreetingResponse
	if err := r.ParseForm(); err != nil {
		gr.Payload.Error = "bad request"
		if payload, err := json.Marshal(gr); err == nil {
			w.Write(payload)
		}
	}
	name := r.FormValue("name")
	greeting := r.FormValue("greeting")

	w.WriteHeader(http.StatusOK)
	gr.Successful = true
	gr.Payload.Name = name
	gr.Payload.Greeting = greeting
	if payload, err := json.Marshal(gr); err == nil {
		w.Write(payload)
	}
}
