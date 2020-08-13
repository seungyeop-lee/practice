package negotiate

import (
	"encoding/xml"
	"net/http"
)

//Payload 구조체는 xml과 json의 레이아웃을 정의한다.
type Payload struct {
	XMLName xml.Name `xml:"payload" json:"-"`
	Status  string   `xml:"status" json:"status"`
}

//Handler 한수는 요청(request)을 인자로 받아
//Negotiator 구조체를 가져오고,
//Payload 구조체를 리턴한다.
func Handler(w http.ResponseWriter, r *http.Request) {
	n := GetNegotiator(r)
	n.Respond(w, http.StatusOK, &Payload{Status: "Successful!"})
}
