package client

import (
	"fmt"
	"net/http"
)

//Controller 구조체는 http.Client를 포함하고 있으며
//내부적으로 http.Client를 사용한다.
type Controller struct {
	*http.Client
}

//DoOps Controller 객체를 갖고 있는 DoOps
func (c *Controller) DoOps() error {
	resp, err := c.Client.Get("http://www.google.com")
	if err != nil {
		return err
	}
	fmt.Println("results of client.DoOps", resp.StatusCode)
	return nil
}