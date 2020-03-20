package part1.chap6.verse1

def x = 1

// 일반적인 if문 내 검사
if (x == 2) {
    assert false
}

// 컴파일러 오류!
/******************
if (x = 2) {
    println x
}
*******************/

// if에서 할당 후, 검사 하려면 ()로 한번 더 감싸야한다.
if ((x = 3)) {
    println x
}
assert x == 3

// while의 할당 후 검사
def store = []
while (x = x - 1) {
    store << x
}
assert store == [2, 1]

// while 문에서는 ()로 안감싸도 할당 후, 검사가 수행된다.
while (x = 1) {
    println x
    break
}
