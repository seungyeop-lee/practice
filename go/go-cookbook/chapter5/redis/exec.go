package redis

import (
	"fmt"
	"gopkg.in/redis.v5"
	"time"
)

func Exec() error {
	conn, err := Setup()
	if err != nil {
		return err
	}

	c1 := "value"
	conn.Set("key", c1, 5*time.Second)

	var result string
	if err := conn.Get("key").Scan(&result); err != nil {
		switch err {
		case redis.Nil:
			return nil
		default:
			return err
		}
	}

	fmt.Println("result = ", result)
	return nil
}
