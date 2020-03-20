package part1.chap7.verse1

class Summer {

    // 인자 명시하기와 디폴트 값
    def sumWithDefaults(a, b, c = 0) {
        return a + b + c
    }
    // 인자를 리스트로 정의
    def sumWithList(List args) {
        return args.inject(0) {sum, i ->
            sum += i
        }
    }
    // 배열을 이용한 옵션 인자
    def sumWithOptionals(a, b, Object[] optionals) {
        return a + b + sumWithList(optionals.toList())
    }
    // 인자를 맵으로 정의
    def sumNamed(Map args) {
        ['a', 'b', 'c'].each { args.get(it, 0) }    // 해당 변수가 없으면 0을 반환
        return args.a + args.b + args.c
    }

}

def summer = new Summer()

assert 2 == summer.sumWithDefaults(1, 1)
assert 3 == summer.sumWithDefaults(1, 1, 1)

assert 2 == summer.sumWithList([1, 1])
assert 3 == summer.sumWithList([1, 1, 1])

assert 2 == summer.sumWithOptionals(1, 1)
assert 3 == summer.sumWithOptionals(1, 1, 1)

assert 2 == summer.sumNamed(a:1, b:1)
assert 3 == summer.sumNamed(a:1, b:1, c:1)
assert 1 == summer.sumNamed(c:1)
