package part1.chap2.verse3

// 그루비에서 숫자는 전부 Wrapper Object로 감싸져있는 객체이다.

def x = 1
def y = 2

assert  x + y == 3
assert x.plus(y) == 3
assert x instanceof Integer

