package main

import "chapter4/global"

func main() {
	if err := global.UseLog(); err != nil {
		panic(err)
	}
}
