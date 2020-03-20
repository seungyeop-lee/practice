package part1.chap7.verse3

def oracle(Object o) {
    return 'object'
}

def oracle(String o) {
    return 'string'
}

Object x = 1
Object y = 'foo'

assert 'object' == oracle(x)
assert 'string' == oracle(y)    // Object에 담겨있어도, 그루비가 문자열임을 감지한다.