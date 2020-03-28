// guess 프로그램은 플레이어가 난수를 맞히는 게임입니다.
package main

import (
	"bufio"
	"fmt"
	"log"
	"math/rand"
	"os"
	"strconv"
	"strings"
	"time"
)

func main() {
	// 현재 시간을 랜덤생성기의 seed로서 사용
	seconds := time.Now().Unix()
	rand.Seed(seconds)

	// 0~99까지 랜덤생성하므로 +1을 한다.
	target := rand.Intn(100) + 1

	fmt.Println("I've chosen a random number between 1 and 100.")
	fmt.Println("Can you guess if?")

	reader := bufio.NewReader(os.Stdin)

	success := false

	// 반복적으로 실행한다.
	for guesses := 0; guesses < 10; guesses++ {
		fmt.Println("You have", 10-guesses, "guesses left.")

		fmt.Print("Make a guess: ")
		// 사용자의 입력을 받는다.
		input, err := reader.ReadString('\n')
		if err != nil {
			log.Fatal(err)
		}
		// 줄 바꿈 문자를 제거한다.
		input = strings.TrimSpace(input)

		// 문자열을 정수로 변환한다.
		guess, err := strconv.Atoi(input)
		if err != nil {
			log.Fatal(err)
		}

		if guess < target {
			fmt.Println("Oops. Your guess was LOW.")
		} else if guess > target {
			fmt.Println("Oops. Your guess was HIGH.")
		} else {
			fmt.Println("Good job! You guessed it!")
			success = true
			break
		}
	}

	if !success {
		fmt.Println("Sorry, you didn't guess my number. It was:", target)
	}
}
