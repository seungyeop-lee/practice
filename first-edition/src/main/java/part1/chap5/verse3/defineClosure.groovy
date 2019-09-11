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