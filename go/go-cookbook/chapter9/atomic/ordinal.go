package atomic

import (
	"sync"
	"sync/atomic"
)

//Ordinal 구조체 타입은 전역 값을 갖고 있으며,
//이 값은 한 번만 초기화할 수 있다.
type Ordinal struct {
	ordinal uint64
	once    *sync.Once
}

//NewOrdinal 함수는 once가 설정된
//Ordinal 구조체를 리턴한다.
func NewOrdinal() *Ordinal {
	return &Ordinal{once: &sync.Once{}}
}

//Init 함수는 순서 값을 설정한다.
//이러한 초기화는 once 를 통해 한 번만 가능하다.
func (o *Ordinal) Init(val uint64) {
	o.once.Do(func() {
		atomic.StoreUint64(&o.ordinal, val)
	})
}

//GetOrdinal 함수는 현재의 순서 값을 가져온다.
func (o *Ordinal) GetOrdinal() uint64 {
	return atomic.LoadUint64(&o.ordinal)
}

//Increment 함수는 현재의 순서 값을 증가시킨다.
func (o *Ordinal) Increment() {
	atomic.AddUint64(&o.ordinal, 1)
}
