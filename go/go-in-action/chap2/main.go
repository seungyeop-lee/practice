package main

import (
	"log"
	"os"
	_ "rssfeeder/matchers"
	"rssfeeder/search"
)

func init() {
	log.SetOutput(os.Stdout)
}

func main() {
	search.Run("a")
}
