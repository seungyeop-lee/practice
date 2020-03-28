// pass_fail 프로그램은 성적의 합격 여부를 알려 줍니다.
package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
	"strings"
)

func main() {
	fmt.Print("Enter a grade: ")

	// 사용자 입력을 줄 바꿈 문자가 나올때 까지 받는다.
	reader := bufio.NewReader(os.Stdin)
	input, err := reader.ReadString('\n')
	if err != nil {
		log.Fatal(err)
	}

	// 줄 바꿈 문자 제거
	input = strings.TrimSpace(input)
	// 문자열을 float64로 변환
	grade, err := strconv.ParseFloat(input, 64)
	if err != nil {
		log.Fatal(err)
	}

	// 합격/불합격 판단
	var status string
	if grade >= 60 {
		status = "passing"
	} else {
		status = "failing"
	}
	fmt.Println("A grade of", grade, "is", status)
}
