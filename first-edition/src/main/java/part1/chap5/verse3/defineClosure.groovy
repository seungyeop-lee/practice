package part1.chap5.verse3

// 인자와 본체를 정의
log = ''
(1..10).each { counter ->
    log += counter
}
assert log == '12345678910'

// 인자가 1개만 있을경우 본체만 정의 (인자는 it로 사용)
log = ''
(1..10).each { log += it }
assert log == '12345678910'

// 클로저를 변수에 직접 할당
def printer = { line ->
    println line
}

// 클로저를 반환하는 메소드
def Closure getPrinter() {
    return { line ->
        println line
    }
}
