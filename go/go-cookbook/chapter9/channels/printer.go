package channels

import (
	"context"
	"fmt"
	"time"
)

//Printer 함수는 ch 채널에서 받은 데이터를 출력하고,
//200밀리초(ms)마다 tock을 출력한다.
//이 동작을 타임아웃(time out)이나 취소로
//컨텍스트가 완료(Done)될 때까지 반복한다.
func Printer(ctx context.Context, ch chan string) {
	t := time.Tick(200 * time.Millisecond)
	for {
		select {
		case <-ctx.Done():
			fmt.Println("printer done.")
			return
		case res := <-ch:
			fmt.Println(res)
		case <-t:
			fmt.Println("tock")
		}
	}
}
