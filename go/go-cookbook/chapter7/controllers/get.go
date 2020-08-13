package controllers

import (
	"encoding/json"
	"net/http"
)

//GetValue 는 HandlerFunc 를 래핑하는 클로저로
//UseDefault 가 참(true)이면 항상 "default" 값을 리턴하고
//그렇지 않으면 스토리지에 저장된 값을 리턴한다.
func (c *Controller) GetValue(UseDefault bool) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {
		w.Header().Set("Content-Type", "application/json")
		if r.Method != http.MethodGet {
			w.WriteHeader(http.StatusMethodNotAllowed)
			return
		}
		value := "default"
		if !UseDefault {
			value = c.storage.Get()
		}
		w.WriteHeader(http.StatusOK)
		p := Payload{Value: value}
		if payload, err := json.Marshal(p); err == nil {
			w.Write(payload)
		}
	}
}
