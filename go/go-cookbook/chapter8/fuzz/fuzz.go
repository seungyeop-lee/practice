package fuzz

//Fuzz 는 gofuzz를 사용하는 데 필요한 인터페이스이다.
func Fuzz(data []byte) int {
	amount := string(data)

	_, err := ConvertStringDollarsToPennies(amount)
	if err != nil {
		return -1
	}
	return 1
}
