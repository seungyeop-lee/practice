package main

import (
	"fmt"
	"listing74/entities"
)

func main() {
	a := entities.Admin{Rights: 10}

	a.Name = "Bill"
	a.Email = "bill@email.com"

	fmt.Printf("사용자: %v\n", a)
}
