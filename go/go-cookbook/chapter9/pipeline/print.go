package pipeline

import (
	"context"
	"fmt"
)

//Print 는 w.in 을 출력하고 이 값을 w.out 으로 보낸다.
func (w *Worker) Print(ctx context.Context) {
	for {
		select {
		case <-ctx.Done():
			return
		case val := <-w.in:
			fmt.Println(val)
			w.out <- val
		}
	}
}
