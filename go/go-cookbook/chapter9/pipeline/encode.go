package pipeline

import (
	"context"
	"encoding/base64"
	"fmt"
)

//Encode 는 in 에서 일반 텍스트를 입력받아
//"입력 문자열" => <base64 인코딩된 문자열>을 out 에 쓴다.
func (w *Worker) Encode(ctx context.Context) {
	for {
		select {
		case <-ctx.Done():
			return
		case val := <-w.in:
			w.out <- fmt.Sprintf("%s => %s", val, base64.StdEncoding.EncodeToString([]byte(val)))
		}
	}
}
