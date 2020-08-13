package fuzz

import (
	"errors"
	"strconv"
	"strings"
)

//ConvertStringDollarsToPennies 함수는 1.00, 55.12와 같은
//문자열로 표시된 달러 값을 인자로 받아 이를 int64로 변환한다.
func ConvertStringDollarsToPennies(amount string) (int64, error) {
	// amount 를 유효한 float 으로 변환 할 수 있는지 확인한다.
	val, err := strconv.ParseFloat(amount, 64)
	if err != nil {
		return 0, err
	}

	if val > 1000 && val < 1100 {
		panic("invalid range")
	}

	// "."를 기준으로 문자열을 나눈다.
	groups := strings.Split(amount, ".")

	// 문자열 내에 . 이 없더라도, 결과는 여전히
	// groups[0]에 저장돼 있을 것이다.
	result := groups[0]

	// 기본 문자열
	r := ""

	// "." 뒤에 나오는 값 처리하기
	if len(groups) == 2 {
		if len(groups[1]) != 2 {
			return 0, errors.New("invalid cents")
		}
		r = groups[1]
		if len(r) > 2 {
			r = r[:2]
		}
	}

	// 0으로 채워 넣기
	// (문자열에 . 이 없다면 0은 2개가 될 것이다.)
	for len(r) < 2 {
		r += "0"
	}

	result += r

	// int로 변환
	return strconv.ParseInt(result, 10, 64)
}
