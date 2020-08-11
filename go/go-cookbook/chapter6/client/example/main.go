package main

import "chapter6/client"

func main() {
	// SSL 검증 및 Op 모드로 동작
	cli := client.Setup(true, false)

	if err := client.DefaultGetGolang(); err != nil {
		panic(err)
	}

	if err := client.DoOps(cli); err != nil {
		panic(err)
	}

	c := client.Controller{Client: cli}
	if err := c.DoOps(); err != nil {
		panic(err)
	}

	// SSL 검증 및 No-op 모드로 동작
	// 이번에도 기본 클라이언트가 변경된다.
	client.Setup(true, true)

	if err := client.DefaultGetGolang(); err != nil {
		panic(err)
	}
}
