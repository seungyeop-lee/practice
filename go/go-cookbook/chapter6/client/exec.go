package client

import (
	"fmt"
	"net/http"
)

//DoOps 함수는 클라이언트를 인자로 받아서
//google.com을 읽어 온다.
func DoOps(c *http.Client) error {
	resp, err := c.Get("http://www.google.com")
	if err != nil {
		return err
	}
	fmt.Println("results of DoOps:", resp.StatusCode)
	return nil
}

//DefaultGetGolang은 기본 클라이언트를 사용해
//golang.org를 읽어 온다.
func DefaultGetGolang() error {
	resp, err := http.Get("https://www.golang.org")
	if err != nil {
		return err
	}
	fmt.Println("results of DefaultGetGolang:", resp.StatusCode)
	return nil
}