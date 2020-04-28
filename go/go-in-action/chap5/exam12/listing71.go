package main

import (
	"fmt"
	"listing71/entities"
)

func main() {
	u := entities.User{
		Name: "Bill",
		//email: "bill@email.com", //비노출 필드이므로 초기화 할 수 없다.
	}

	fmt.Printf("사용자: %v\n", u)
}
