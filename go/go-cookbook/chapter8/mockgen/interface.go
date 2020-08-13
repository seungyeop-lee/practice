package mockgen

//GetSetter 는 키-값 쌍(key-value pair)을
//저장하고 가져오는 인터페이스 타입이다.
type GetSetter interface {
	Get(key string) (string, error)
	Set(key, val string) error
}
