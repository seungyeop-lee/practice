package main

import "chapter5/storage"

func main() {
	if err := storage.Exec(); err != nil {
		panic(err)
	}
}
