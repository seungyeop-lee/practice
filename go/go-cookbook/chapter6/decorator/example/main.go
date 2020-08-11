package main

import "chapter6/decorator"

func main() {
	if err := decorator.Exec(); err != nil {
		panic(err)
	}
}
