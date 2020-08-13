package mocking

type MockDoStuffer struct {
	// 모킹을 돕기 위한 클로저
	MockDoStuff func(input string) error
}

func (m *MockDoStuffer) DoStuff(input string) error {
	if m.MockDoStuff != nil {
		return m.MockDoStuff(input)
	}
	//모조품을 만들지 않았다면 일반적인 경우를 리턴한다.
	return nil
}
