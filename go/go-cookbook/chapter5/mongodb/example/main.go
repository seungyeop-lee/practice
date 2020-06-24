package main

import "chapter5/mongodb"

func main() {
	if err := mongodb.Exec(); err != nil {
		panic(err)
	}
}
