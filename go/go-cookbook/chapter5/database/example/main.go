package main

import "chapter5/database"

func main() {
	db, err := database.Setup()
	if err != nil {
		panic(err)
	}
	if err := database.Exec(db); err != nil {
		panic(err)
	}
}
