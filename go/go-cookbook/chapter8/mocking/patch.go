package mocking

import "reflect"

//Restorer 함수 타입은 이전 상태를 복원하기 위해
//사용할 수 있는 함수를 보유하고 있다.
type Restorer func()

//Restore 함수를 호출하면 이전 상태로 복원된다.
func (r Restorer) Restore() {
	r()
}

//Patch 함수는 지정된 대상(destination)이 가리키는 값을 주어진 값으로
//설정하고, 이를 원래 상태로 되돌릴 수 있는 함수를 리턴한다.
//이 값은 반드시 대상 타입의 객체에
//할당 가능 (assignable)해야 한다.
func Patch(dest, value interface{}) Restorer {
	destv := reflect.ValueOf(dest).Elem()
	oldv := reflect.New(destv.Type()).Elem()
	oldv.Set(destv)
	valuev := reflect.ValueOf(value)
	if !valuev.IsValid() {
		//대상 타입이 nil 값을 가질 수 없는 타입인 경우,
		//이렇게 처리하는 것은 좋은 방법이라고 할 수 없지만
		//다른 복잡한 방법을 사용하는 것보단 낫다.
		valuev = reflect.Zero(destv.Type())
	}
	destv.Set(valuev)
	return func() {
		destv.Set(oldv)
	}
}
