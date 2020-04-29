package main

import (
	"log"
	"os"
	"runner"
	"time"
)

const timeout = 3 * time.Second

func main() {
	log.Println("작업을 시작합니다.")

	r := runner.New(timeout)

	r.Add(createTask(), createTask(), createTask())

	if err := r.Start(); err != nil {
		switch err {
		case runner.ErrTimeout:
			log.Println("지정된 작업 시간을 초과하였습니다.")
			os.Exit(1)
		case runner.ErrInterrupt:
			log.Println("운영체제 인터럽트가 발생했습니다.")
			os.Exit(2)
		}
	}

	log.Println("프로그램을 종료합니다.")
}

func createTask() func(int) {
	return func(id int) {
		log.Printf("프로세서 - 작업 #%d.", id)
		time.Sleep(time.Duration(id) * time.Second)
	}
}
