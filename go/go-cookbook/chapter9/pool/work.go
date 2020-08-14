package pool

import "errors"

type op string

const (
	Hash    op = "encrypt" //Hash 는 bcrypt 의 작업 유형이다.
	Compare    = "decrypt" //Compare 는 bcrypt 의 비교 작업이다.
)

//WorkRequest 는 작업자에 대한 요구(req)이다.
type WorkRequest struct {
	Op      op
	Text    []byte
	Compare []byte //선택 사항
}

//WorkResponse 는 작업자의 응답(resp)이다.
type WorkResponse struct {
	Wr      WorkRequest
	Result  []byte
	Matched bool
	Err     error
}

//Process 함수는 작업자 풀의 채널로 작업(work)을 전달한다.
func Process(wr WorkRequest) WorkResponse {
	switch wr.Op {
	case Hash:
		return hashWork(wr)
	case Compare:
		return compareWork(wr)
	default:
		return WorkResponse{Err: errors.New("unsupported operation")}
	}
}
