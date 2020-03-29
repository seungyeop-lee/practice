package main

import (
	"fmt"
	"log"

	"github.com/seungyeop-lee/practice/go/head-first-go/chap6/datafile"
)

func main() {
	lines, err := datafile.GetStrings("votes.txt")
	if err != nil {
		log.Fatal(err)
	}

	counts := make(map[string]int)
	for _, line := range lines {
		counts[line]++
	}

	for name, count := range counts {
		fmt.Printf("Votes for %s: %d\n", name, count)
	}
	//var names []string
	//var counts []int
	//for _, line := range lines {
	//	matched := false
	//	for i, name := range names {
	//		if name == line {
	//			counts[i]++
	//			matched = true
	//		}
	//	}
	//	if matched == false {
	//		names = append(names, line)
	//		counts = append(counts, 1)
	//	}
	//}
	//
	//for i, name := range names {
	//	fmt.Printf("%s: %d\n", name, counts[i])
	//}
}
