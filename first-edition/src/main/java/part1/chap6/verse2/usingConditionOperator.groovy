package part1.chap6.verse2

// 일반적인 삼항 연산자
def result = (1 == 1) ? 'ok' : 'failed'
assert result == 'ok'

// 조건문으로 문자열을 넣으면 true
result = 'some string' ? 10 : ['x']
assert result == 10