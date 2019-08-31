package part1.chap2.verse3

//배열을 []로 표현한다. 실제적으론 java.util.List 객체
def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII']
assert roman[4] == 'IV'
assert roman.size() == 8
//배열의 index에 새로운 값을 넣으면 배열의 길이는 그 만큼 증가한다.
roman[8] = 'VIII'
assert roman.size() == 9

//Map도 []로 표현하되 :를 기준으로 키와 값을 설정
def http = [
        100 : 'CONTINUE',
        200 : 'OK',
        400 : 'BAD REQUEST'
]
//배열의 index로 값을 가져오는 것과 동일한 방식으로 접근가능
assert http[200] == 'OK'
assert http.size() == 3
//새로운 값의 추가 가능
http[500] = 'INTERNAL SERVER ERROR'
assert http.size() == 4

//숫자..숫자를 이용하면 숫자의 범위를 정의 할 수 있음
def x = 1..10
//숫자의 범위(IntRange)객체에 관련 속성 및 메소드가 제공 됨
assert x.contains(5)
assert !x.contains(15)
assert x.size() == 10
assert x.from == 1
assert x.to == 10
assert x.reverse() == 10..1