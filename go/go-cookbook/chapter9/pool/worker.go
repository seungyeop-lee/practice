package pool

import (
	"context"
	"fmt"
)

//Dispatch 는 numWorker 작업자를 만들고, 취소(cancel) 함수 및 작업(work)과 응답(response)을 추가하고
//취소 함수를 호출해야 하는 채널(in, out)을 리턴한다.
func Dispatch(numWorker int) (cancel context.CancelFunc, in chan WorkRequest, out chan WorkResponse) {
	ctx := context.Background()
	ctx, cancel = context.WithCancel(ctx)
	in = make(chan WorkRequest, 10)
	out = make(chan WorkResponse, 10)

	for i := 0; i < numWorker; i++ {
		go Worker(ctx, i, in, out)
	}
	return cancel, in, out
}

//Worker 는 영원히 반복되는 작업자 풀의 일부이다.
func Worker(ctx context.Context, id int, in chan WorkRequest, out chan WorkResponse) {
	for {
		select {
		case <-ctx.Done():
			return
		case wr := <-in:
			fmt.Printf("worker id: %d, performing %s work\n", id, wr.Op)
			out <- Process(wr)
		}
	}
}
