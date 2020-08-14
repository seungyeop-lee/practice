package state

type op string

const (
	Add      op = "add"
	Subtract    = "sub"
	Multiply    = "mult"
	Divide      = "div"
)

//WorkRequest 는 두 값에 대해 op 연산을 수행한다.
type WorkRequest struct {
	Operation op
	Value1    int64
	Value2    int64
}

//WorkResponse 는 결괏값이나 에러를 리턴한다.
type WorkResponse struct {
	Wr     *WorkRequest
	Result int64
	Err    error
}
