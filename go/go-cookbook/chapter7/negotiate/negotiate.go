package negotiate

import (
	"net/http"

	"github.com/unrolled/render"
)

//Negotiator 는 render 를 감싸고
//ContentType 에 따른 전환(switch)을 처리한다.
type Negotiator struct {
	ContentType string
	*render.Render
}

//GetNegotiator 함수는 요청(http.Request)을 인자로 받아
//콘텐트 타입 헤더(ContentType header)에서
//콘텐트 타입(ContentType)을 가져온다.
func GetNegotiator(r *http.Request) *Negotiator {
	contentType := r.Header.Get("Content-Type")
	return &Negotiator{
		ContentType: contentType,
		Render:      render.New(),
	}
}
