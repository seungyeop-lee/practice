package coverage

import "errors"

//Coverage 는 몇가지 분기 조건을 가진 간단한 함수이다.
func Coverage(condition bool) error {
	if condition {
		return errors.New("condition was set")
	}
	return nil
}
