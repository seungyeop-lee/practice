package main

import "fmt"

type duration int

func (d *duration) pretty() string {
	return fmt.Sprintf("기간: %d", *d)
}

func main() {
	// 값의 주소는 항상 알아 낼 수 있는건 아니다.
	//duration(42).pretty()
}
