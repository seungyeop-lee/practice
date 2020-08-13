package mocking

//DoStuffer 는 간단한 인터페이스이다.
type DoStuffer interface {
	DoStuff(input string) error
}
