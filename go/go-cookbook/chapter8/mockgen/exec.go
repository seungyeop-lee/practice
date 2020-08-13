package mockgen

//Controller 는 인터페이스를 초기화하는
//방법 중 하나를 보여주는 구조체이다.
type Controller struct {
	GetSetter
}

//GetThenSet 함수는 값이 설정돼 있는지 확인한다.
//설정돼 있지 않으면 값을 설정한다.
func (c *Controller) GetThenSet(key, value string) error {
	val, err := c.Get(key)
	if err != nil {
		return err
	}

	if val != value {
		return c.Set(key, value)
	}
	return nil
}
