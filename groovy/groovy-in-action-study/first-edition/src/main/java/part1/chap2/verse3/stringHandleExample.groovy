package part1.chap2.verse3

// GStrings
def nick = 'Gina'
def book = 'Groovy in Action'
// 큰 따옴표에서는 $변수 를 사용하여 변수의 값을 문자열 사이에 넣는 것이 가능하다.
assert "$nick is $book" == 'Gina is Groovy in Action'

// regex
// 슬래시 연산자(//)로 정규표현식을 표현
// 검색 연산자(=~)로 주어진 문자열에 해당 패턴의 유무 판단
assert '12345' =~ /\d+/
// 정규표현식에 해당하는 문자열을 모두 두번째 인수로 설정한 문자열로 교체한다.
assert 'xxxxx' == '12345'.replaceAll(/\d/, 'x')