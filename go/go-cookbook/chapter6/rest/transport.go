package rest

import "net/http"

//APITransport 는 모든 요청에 대해
//SetBasicAuth 를 수행한다.
type APITransport struct {
	*http.Transport
	username, password string
}

func (t *APITransport) RoundTrip(req *http.Request) (*http.Response, error){
	req.SetBasicAuth(t.username, t.password)
	return t.Transport.RoundTrip(req)
}