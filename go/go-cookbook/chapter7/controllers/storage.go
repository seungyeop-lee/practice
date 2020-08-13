package controllers

//Storage 인터페이스는 하나의 값에 대한
//Get(가져오기)과 Put(저장하기) 메서드를 지원한다.
type Storage interface {
	Get() string
	Put(string)
}

//MemStorage 는 Storage 인터페이스를 구현한다.
type MemStorage struct {
	value string
}

//Get 함수는 메모리 내부(in-memory)의 값을 가져온다.
func (m *MemStorage) Get() string {
	return m.value
}

//Put 함수는 메모리 내부에 값을 저장한다.
func (m *MemStorage) Put(s string) {
	m.value = s
}
