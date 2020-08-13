package main

import (
	"chapter7/grpcjson/internal"
	"chapter7/grpcjson/keyvalue"
	"encoding/json"
	"net/http"

	"github.com/apex/log"
)

type Controller struct {
	*internal.KeyValue
}

//SetHandler 는 GRPC Set 함수를 래핑하고 있다.
func (c *Controller) SetHandler(w http.ResponseWriter, r *http.Request) {
	var kv keyvalue.SetKeyValueRequest

	decoder := json.NewDecoder(r.Body)
	if err := decoder.Decode(&kv); err != nil {
		log.Errorf("failed to decode: &s", err.Error())
		w.WriteHeader(http.StatusBadRequest)
		return
	}

	gresp, err := c.Set(r.Context(), &kv)
	if err != nil {
		log.Errorf("failed to set: %s", err.Error())
		w.WriteHeader(http.StatusInternalServerError)
		return
	}

	resp, err := json.Marshal(gresp)
	if err != nil {
		log.Errorf("failed to marshal: %s", err.Error())
		w.WriteHeader(http.StatusInternalServerError)
		return
	}

	w.WriteHeader(http.StatusOK)
	w.Write(resp)
}
