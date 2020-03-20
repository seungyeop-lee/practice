package part1.chap7.verse1

class PretendFieldCounter {
    public count = 0

    // '도트 필드 변수 이름' 연산자의 재정의
    Object get(String name) {
        return 'pretend value'
    }
    // '필드 변수 할당' 연산자의 재정의
    void set(String name, Object value) {
        count++
    }
}

def pretender = new PretendFieldCounter()

assert pretender.isNoField == 'pretend value'
assert pretender.count == 0

pretender.isNoFieldEither = 'just to increase counter'

assert pretender.count == 1