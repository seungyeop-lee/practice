package decorator

import "net/http"

//TransportFunc 는 RoundTripper 인터페이스를 구현한다.
type TransportFunc func(r *http.Request) (*http.Response, error)

//RoundTrip 은 원래 함수를 호출한다.
func (tf TransportFunc) RoundTrip(r *http.Request) (*http.Response, error) {
	return tf(r)
}

//Decorator 는 미들웨어 내부의 함수(middleware inner function)를
//나타내는 편의 함수(convenience function)이다.
type Decorator func(tripper http.RoundTripper) http.RoundTripper

func Decorate(t http.RoundTripper, rts ...Decorator) http.RoundTripper {
	decorated := t
	for _, rt := range rts {
		decorated = rt(decorated)
	}
	return decorated
}
