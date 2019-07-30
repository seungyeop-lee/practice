package part1.chap2.verse3

def x = 1
def y = 2

assert x + y == 3
//Groovy에서는 연산자가 실제로는 메소드로 실행 됨
assert x.plus(y) == 3
//모든 숫자는 전부 Wrapper클래스로 감싸져있음
assert x instanceof Integer