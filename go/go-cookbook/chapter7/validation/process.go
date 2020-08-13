package validation

import (
	"encoding/json"
	"fmt"
	"net/http"
)

//Process 함수는 post 요청된 페이로드의 유효성을 검사하는 핸들러이다.
func (c *Controller) Process(w http.ResponseWriter, r *http.Request) {
	if r.Method != http.MethodPost {
		w.WriteHeader(http.StatusMethodNotAllowed)
		return
	}

	decoder := json.NewDecoder(r.Body)
	defer r.Body.Close()
	var p Payload

	if err := decoder.Decode(&p); err != nil {
		fmt.Println(err)
		w.WriteHeader(http.StatusBadRequest)
		return
	}

	if err := c.ValidatePayload(&p); err != nil {
		switch err.(type) {
		case Verror:
			w.WriteHeader(http.StatusBadRequest)
			//Verror 를 전달한다.
			w.Write([]byte(err.Error()))
			return
		default:
			w.WriteHeader(http.StatusInternalServerError)
			return
		}
	}
}
