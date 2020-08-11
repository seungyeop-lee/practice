package main

import "chapter6/rest"

func main() {
	if err := rest.Exec(); err != nil {
		panic(err)
	}
}
