package proxy

import (
	"log"
	"net/http"
)

//Proxy 구조체는 우리가 구성한 클라이언트(http.Client)를 갖고 있으며,
//프록시(proxy) 접속할 BaseURL 문자열을 갖고 있다.
type Proxy struct {
	Client  *http.Client
	BaseURL string
}

//ServeHTTP 함수는 Proxy 구조체 타입이 Handler 인터페이스를 구현하고 있음을 의미한다.
//이 함수는 요청(request)을 조작하고 이 요청을 BaseURL 로 포워딩하여, 응답(response)을 리턴한다.
func (p *Proxy) ServeHTTP(w http.ResponseWriter, r *http.Request) {
	if err := p.ProcessRequest(r); err != nil {
		log.Printf("error occurred during process request: %s", err.Error())
		w.WriteHeader(http.StatusBadRequest)
		return
	}

	resp, err := p.Client.Do(r)
	if err != nil {
		log.Printf("error occurred during client operation: %s", err.Error())
		w.WriteHeader(http.StatusInternalServerError)
		return
	}
	defer resp.Body.Close()
	CopyResponse(w, resp)
}
