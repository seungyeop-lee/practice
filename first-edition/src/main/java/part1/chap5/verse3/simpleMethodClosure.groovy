package part1.chap5.verse3

class MethodClosureSample {
    int limit

    MethodClosureSample (int limit) {
        this.limit = limit
    }

    boolean validate(String value) {
        return value.length() <= limit
    }
}

MethodClosureSample first = new MethodClosureSample(6)
MethodClosureSample second = new MethodClosureSample(5)

// 객체의 메서드를 클로저로서 변수에 할당이 가능하다.
Closure firstClosure = first.&validate

def words = ['long string', 'medium', 'short', 'tiny']

// 자바의 람다와 클로저의 차이 점으로는
// 클로저는 객체의 메서드에서 사용하고 있는 필드 값도 사용이 가능하다는 것이다.
assert 'medium' == words.find(firstClosure)
assert 'short' == words.find(second.&validate)