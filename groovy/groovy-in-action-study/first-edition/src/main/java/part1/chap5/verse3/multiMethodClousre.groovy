package part1.chap5.verse3

class MultiMethodSample {
    int mysteryMethod(String value) {
        return value.length()
    }

    int mysteryMethod(List list) {
        return list.size()
    }

    int mysteryMethod(int x, int y) {
        return x + y
    }
}

MultiMethodSample instance = new MultiMethodSample()
Closure multi = instance.&mysteryMethod

// 객체에 메서드가 오버로딩 되어있을 경우
// 메서드 클로저 사용 시 모든 오버로딩 된 메소드를 클로저로 한번에 사용이 가능하다.
assert 10 == multi ('string arg')
assert 3 == multi (['list', 'of', 'values'])
assert 14 == multi (6, 8)