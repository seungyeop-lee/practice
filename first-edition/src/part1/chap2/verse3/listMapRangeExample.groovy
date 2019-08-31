package part1.chap2.verse3

// 리스트
def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII']

assert roman[4] == 'IV' // 리스트 접근

roman[8] = 'VIII'   // 리스트 확장
assert roman.size() == 9    // 리스트의 크기가 자동으로 증가

// 맵
def http = [
        100: 'CONTINUE',
        200: 'OK',
        400: 'BAD REQUEST'
]
assert http[200] == 'OK'    // 맵 접근

http[500] = 'INTERNAL SERVER ERROR' // 맵 확장
assert http.size() == 4 // 맵의 크기가 자동으로 증가

// 범위
def x = 1..10
assert x.contains(5)
assert x.contains(15) == false
assert x.size() == 10
assert x.from == 1
assert x.to == 10
assert  x.reverse() == 10..1