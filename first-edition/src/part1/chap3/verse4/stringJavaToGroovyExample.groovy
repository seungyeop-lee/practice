package part1.chap3.verse4

// 자바에서 그루비 문법으로
System.out.println("Hello Groovy!");  // 일반적인 자바문법, 그루비에서도 잘 작동된다.
System.out.println('Hello Groovy!');  // 문자열을 Groovy의 문자열로 변환
println('Hello Groovy!'); // System.out은 자동 import되므로 생략
println 'Hello Groovy!'   // 메소드의 괄호와 세미콜론을 삭제


// 그루비에서 문자열로 하는 일들
greeting = 'Hello Groovy!'

assert greeting.startsWith('Hello') // 특정 문자열로 시작 여부 확인

assert greeting.getAt(0) == 'H' // index로 특정 부분의 char 획득
assert greeting[0] == 'H'

assert greeting.indexOf('Groovy') >= 0  // 특정 문자열의 시작 위치 확인
assert greeting.contains('Groovy')  // 특정 문자열의 포함 유무 확인

assert greeting[6..11] == 'Groovy'  // 범위로 특정 부분의 문자열 획득

assert 'Hi' + greeting - 'Hello' == 'Hi Groovy!'    // + 로 문자열을 연결하고, - 로 문자열을 제거

assert greeting.count('o') == 3 // 특정 char의 갯수 확인

assert 'x'.padLeft(3) == '  x'  // 설정한 인수의 갯수가 되도록 왼쪽에 공백을 삽입
assert 'x'.padRight(3, '_') == 'x__'    // 설정한 인수의 갯수가 되도록 오른쪽에 설정한 문자를 삽입
assert 'x'.center(3) == ' x '   // 설정한 인수의 갯수가 되도록 왼쪽과 오른쪽에 동일한 숫자의 공백을 삽입
assert 'x' * 3 == 'xxx' // * 로 문자열을 복제한 문자열 반환


// 그루비에서의 문자열 조작
greeting = 'Hello'

greeting <<= ' Groovy'  // 시프트 연산과 동시에 할당 (처음 시프트 연산을 할 땐 할당을 꼭 해야 한다; String은 불변이기 때문)
assert greeting instanceof StringBuffer // 시프트 연산을 할경우 StringBuffer가 리턴 됨
assert greeting.toString() == 'Hello Groovy'

greeting << '!' // StringBuffer인 경우 시프트 연산만으로 조작 가능
assert greeting.toString() == 'Hello Groovy!'

greeting[1..4] = 'i'    // 범위를 대입 문자열로 치환 가능
assert greeting.toString() == 'Hi Groovy!'