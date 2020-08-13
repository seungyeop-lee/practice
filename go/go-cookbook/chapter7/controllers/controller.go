package controllers

//Controller 는 우리가 만든 핸들러에 상태(state)를 전달한다.
type Controller struct {
	storage Storage
}

//New 함수는 Controller 의 '생성자(constructor)'이다.
func New(storage Storage) *Controller {
	return &Controller{
		storage: storage,
	}
}

//Payload 구조체는 일반적인 응답(response)이다.
type Payload struct {
	Value string `json:"value"`
}
