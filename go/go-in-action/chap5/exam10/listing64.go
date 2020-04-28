package main

import (
	"fmt"
	"listing64/counters"
)

func main() {
	counter := counters.AlertCounter(10)

	fmt.Printf("카운터: %d\n", counter)
}
