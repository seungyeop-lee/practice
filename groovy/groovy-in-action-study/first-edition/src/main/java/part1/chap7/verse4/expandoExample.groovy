package part1.chap7.verse4

// 확장 가능한 그루비 빈
def boxer = new Expando()

// 선언되어 있지 않는 필드로 접근시 null 반환
assert null == boxer.takeThis

// 선언되어 있지 않는 필드에 대입하면 선언과 정의가 이루어짐
boxer.takeThis = 'ouch!'
assert 'ouch!' == boxer.takeThis

// 필드에 클로저를 사용하는 것이 가능
// 먼저 선언 및 정의 한 필드를 클로저 내에서 사용하는 것도 가능
boxer.fightBack = { times -> return takeThis * times }
assert 'ouch!ouch!ouch!' == boxer.fightBack(3)

// 단점
// 자바쪽에서는 빈으로 사용불가
// 자료형을 지원하지 않음