package async

import "net/http"

//NewClient 함수는 새 클라이언트를 만들고
//적절한 채널을 설정한다.
func NewClient(client *http.Client, bufferSize int) *Client {
	respch := make(chan *http.Response, bufferSize)
	errch := make(chan error, bufferSize)
	return &Client{
		Client: client,
		Resp: respch,
		Err: errch,
	}
}

//Client 구조체는 클라이언트를 저장하고 있으며
//응답과 에러를 처리할 채널 두 개를 갖고 있다.
type Client struct {
	*http.Client
	Resp   chan *http.Response
	Err    chan error
}

//AsyncGet 은 Get 요청을 수행한 다음
//적절한 채널로 응답 또는 에러를 리턴한다.
func (c *Client) AsyncGet(url string) {
	resp, err := c.Get(url)
	if err != nil {
		c.Err <- err
		return
	}
	c.Resp <- resp
}