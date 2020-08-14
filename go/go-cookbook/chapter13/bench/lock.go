package bench

import "sync"

//Counter 는 안전하게 값을 변경하기 위해
//sync.RWMutex 를 사용한다.
type Counter struct {
	value int64
	mu    *sync.RWMutex
}

//Add 는 Counter 값을 증가시킨다.
func (c *Counter) Add(amount int64) {
	c.mu.Lock()
	c.value += amount
	c.mu.Unlock()
}

//Read 는 현태 Counter 값을 리턴한다.
func (c *Counter) Read() int64 {
	c.mu.RLock()
	defer c.mu.RUnlock()
	return c.value
}
