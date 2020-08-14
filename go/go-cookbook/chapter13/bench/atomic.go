package bench

import "sync/atomic"

//AtomicCounter 는 atomic 패키지를 사용해
//아토믹 잠금(atomic lock)을 구현한다.
type AtomicCounter struct {
	value int64
}

//Add 는 Counter 값을 증가시킨다.
func (c *AtomicCounter) Add(amount int64) {
	atomic.AddInt64(&c.value, amount)
}

//Read 는 현재 Counter 값을 리턴한다.
func (c *AtomicCounter) Read() int64 {
	var result int64
	result = atomic.LoadInt64(&c.value)
	return result
}
