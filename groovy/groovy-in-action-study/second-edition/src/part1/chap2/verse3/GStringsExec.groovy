package part1.chap2.verse3

def nick = 'ReGina'
def book = 'Groovy in Action, 2nd ed.'
//$변수명 으로 문자열안에 특정 변수의 문자열을 삽입 할 수 있다.
//$변수명은 "" 안에서만 사용가능하며, ""를 GStrings라고 한다.
assert "$nick is $book" == 'ReGina is Groovy in Action, 2nd ed.'