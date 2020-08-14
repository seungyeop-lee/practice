package main

import (
	"chapter9/channels"
	"context"
	"time"
)

func main() {
	ch := make(chan string)
	done := make(chan bool)

	ctx := context.Background()
	ctx, cancel := context.WithCancel(ctx)
	defer cancel()

	go channels.Printer(ctx, ch)
	go channels.Sender(ch, done)

	time.Sleep(2 * time.Second)
	done <- true
	cancel()

	//채널이 정리될 때까지 조금 더 대기한다.
	time.Sleep(1 * time.Second)
}
