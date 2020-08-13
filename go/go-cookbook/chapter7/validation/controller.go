package validation

//Controller 구조체는 우리가 만든 검증 함수(validation function)을 갖고 있다.
type Controller struct {
	ValidatePayload func(p *Payload) error
}

//New 는 재정의(overwritten)될 수 있는
//로컬 검증 함수로 컨트롤러를 초기화한다.
func New() *Controller {
	return &Controller{
		ValidatePayload: ValidatePayload,
	}
}
