package validation

import "errors"

//Verror 는 검증 과정에서 발생하는
//에러로 이것을 사용자에게 리턴할 수 있다.
type Verror struct {
	error
}

//Payload 는 처리해야 할 값이다.
type Payload struct {
	Name string `json:"name"`
	Age  int    `json:"age"`
}

//ValidatePayload 는 컨트롤러에서 구현한 클로저 중의 하나이다.
func ValidatePayload(p *Payload) error {
	if p.Name == "" {
		return Verror{errors.New("name is required")}
	}

	if p.Age <= 0 || p.Age >= 120 {
		return Verror{errors.New("age is required and must be a value greater than 0 and less than 120")}
	}

	return nil
}
