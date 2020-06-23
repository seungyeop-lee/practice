package math

import "math/big"

var memorize map[int]*big.Int

func init() {
	memorize = make(map[int]*big.Int)
}

func Fib(n int) *big.Int {
	if n < 0 {
		return nil
	}

	if n < 2 {
		memorize[n] = big.NewInt(1)
	}

	if val, ok := memorize[n]; ok {
		return val
	}

	memorize[n] = big.NewInt(0)
	memorize[n].Add(memorize[n], Fib(n - 1))
	memorize[n].Add(memorize[n], Fib(n - 2))

	return memorize[n]
}