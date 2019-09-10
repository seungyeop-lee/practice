package part1.chap4.verse1

import java.time.LocalTime

// 양쪽 경계를 포함하는 범위
assert (0..10).contains(0)
assert (0..10).contains(5)
assert (0..10).contains(10)
assert (0..10).contains(-1) == false
assert (0..10).contains(11) == false

// 한쪽 경계만 포함하는 범위
assert (0..<10).contains(9)
assert (0..<10).contains(10) == false

// 범위는 Range 타입의 객체
def a = 0..10
assert a instanceof Range
assert a.contains(5)

// 명시적 범위 생성
a = new IntRange(0, 10)
assert a.contains(5)

// 소수의 범위 생성
assert (0.0..1.0).containsWithinBounds(0.5)

// 날짜의 범위 생성
def today = LocalTime.now()
def yesterday = today - 1
assert (yesterday..today).size() == 2

// 문자열의 범위 생성
assert ('a'..'c').contains('b')

// 범위 + for-in
def log = ''
for (element in 5..9) {
    log += element
}
assert log == '56789'

// 역범위 + for-in
log = ''
for (element in 9..5) {
    log += element
}
assert log == '98765'

// 역범위 + each(clojure)
log = ''
(9..<5).each { element ->
    log += element
}
assert log == '9876'