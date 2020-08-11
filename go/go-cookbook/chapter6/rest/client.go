package rest

import "net/http"

//APIClient 는 사용자 정의(custom) 클라이언트이다.
type APIClient struct {
	*http.Client
}

//NewAPIClient 생성자는 우리가 정의한
//트랜스포트(transport)로 클라이언트를 초기화한다.
func NewAPIClient(username, password string) *APIClient {
	t := http.Transport{}
	return &APIClient{
		Client: &http.Client{
			Transport: &APITransport{
				Transport: &t,
				username: username,
				password: password,
			},
		},
	}
}

//GetGoogle 은 API 호출이다 - REST 부분은 추상화했다.
func (c *APIClient) GetGoogle() (int, error) {
	resp, err := c.Get("http://www.google.com")
	if err != nil {
		return 0, err
	}
	return resp.StatusCode, nil
}