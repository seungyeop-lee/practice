package main

import (
	"fmt"
	"listing68/counters"
)

func main() {
	counter := counters.New(10)

	fmt.Printf("카운터: %d\n", counter)
}
