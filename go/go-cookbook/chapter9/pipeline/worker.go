package pipeline

import "context"

//Worker 는 Work 가 호출됐을 때
//결정되는 하나의 역할 만 수행한다.
type Worker struct {
	in  chan string
	out chan string
}

//Job 은 작업자가 할 수 있는 작업니다.
type Job string

const (
	//Print 는 모든 입력을 표준 출력(stdout)에 출력한다.
	Print Job = "print"
	//Encode 는 입력값을 base64로 인코딩한다.
	Encode Job = "encode"
)

//Work 함수는 작업자에게
//여기에서 할당된 작업을 전달한다.
func (w *Worker) Work(ctx context.Context, j Job) {
	switch j {
	case Print:
		w.Print(ctx)
	case Encode:
		w.Encode(ctx)
	default:
		return
	}
}
