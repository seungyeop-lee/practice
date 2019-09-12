package part1.chap5.verse6

// return 을 명시하지 않으면, 마지막 구문의 결과값이 반환된다.
assert [1,2,3].collect { it * 2 } == [2,4,6]
// return 을 명시해도 된다.
assert [1,2,3].collect { return it * 2 } == [2,4,6]

// 일반 메서드처럼 중간에서 return 하는 것도 가능하다.
assert [1,2,3].collect {
    if (it % 2 == 0) return it * 2
    return it
} == [1,4,3]