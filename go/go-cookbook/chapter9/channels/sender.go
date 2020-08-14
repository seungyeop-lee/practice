package channels

import "time"

//Sender 함수는 done 채널에 데이터가 기록될 때까지
//ch 채널에 "tick"을 보내고, done 채널에 데이터가
//기록되면 "sender done"을 보내고 종료한다.
func Sender(ch chan string, done chan bool) {
	t := time.Tick(100 * time.Millisecond)
	for {
		select {
		case <-done:
			ch <- "sender done."
			return
		case <-t:
			ch <- "tick"
		}
	}
}
