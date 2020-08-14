package atomic

import (
	"errors"
	"sync"
)

//SafeMap 은 스레드에 안전한(thread-safe) 방법으로
//값을 가져오거나 저장하도록 하기 위해 뮤텍스를 사용한다.
type SafeMap struct {
	m  map[string]string
	mu *sync.RWMutex
}

//NewSafeMap 이 SafeMap 을 생성한다.
func NewSafeMap() SafeMap {
	return SafeMap{m: make(map[string]string), mu: &sync.RWMutex{}}
}

//Set 함수는 쓰기 잠금(write lock)을 사용하며
//주어진 키(key)에 값을 설정한다.
func (t *SafeMap) Set(key, value string) {
	t.mu.Lock()
	defer t.mu.Unlock()

	t.m[key] = value
}

//Get 함수는 RW(읽기/쓰기) 잠금을 사용하며
//값이 있으면 값을 가져오고, 없으면 에러를 리턴한다.
func (t *SafeMap) Get(key string) (string, error) {
	t.mu.RLock()
	defer t.mu.RUnlock()

	if v, ok := t.m[key]; ok {
		return v, nil
	}

	return "", errors.New("key not found")
}
