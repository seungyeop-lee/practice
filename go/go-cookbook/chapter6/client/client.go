package client

import (
	"crypto/tls"
	"net/http"
)

// Setup 함수는 클라이언트를 구성하고
// 전역 DefaultClient를 재정의(redefine)한다.
func Setup(isSecure, nop bool) *http.Client {
	c := http.DefaultClient

	// 테스트를 위해 SSL 검증(verification)을
	// 사용하지 않을 수도 있다.
	if !isSecure {
		c.Transport = &http.Transport{
			TLSClientConfig: &tls.Config{
				InsecureSkipVerify: false,
			},
		}
	}

	if nop {
		c.Transport = &NopTransport{}
	}
	http.DefaultClient = c
	return c
}

// NopTransport 함수는
// 아무것도 하지 않는(No-Op) 전송이다.
type NopTransport struct {
}

//RoundTrip 함수는 RoundTripper 인터페이스를 구현한다.
func (n *NopTransport) RoundTrip(*http.Request) (*http.Response, error) {
	// 헤더 등을 살펴보면 이것은 초기화되지 않은
	// 응답(response)임을 알 수 있다.
	return &http.Response{StatusCode: http.StatusTeapot}, nil
}

