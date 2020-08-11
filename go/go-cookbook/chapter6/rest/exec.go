package rest

import "fmt"

//Exec 은 API 클라이언트를 생성하고
//GetGoogle 메소드를 실행한 다음 결과를 출력한다.
func Exec() error {
	c := NewAPIClient("username", "password")

	StatusCode, err := c.GetGoogle()
	if err != nil {
		return err
	}
	fmt.Println("Result of GetGoogle:", StatusCode)
	return nil
}
