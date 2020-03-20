package part1.chap2.verse3

//if조건문이 false이면 그 구문을 실행시키지 않는다.
if (false) assert false
//if조건문이 true이면 그 구문을 실행시킨다.
if (true) assert true

//if조건문이 null이면 false와 동일한 취급을 한다
if (null) {
    assert false
} else {
    assert true
}

//자바의 while과 동일하게 사용
def i = 0
while (i < 10) {
    i++
}
assert i == 10

//range와 for-in문의 결합가능
def clinks = 0
for (remainingGuests in 0..9) {
    clinks += remainingGuests
}
assert clinks == (10 * 9) / 2

def list = [0, 1, 2, 3]

//list와 for-in문의 결합가능
for (j in list) {
    assert j == list[j]
}

//each메소드와 클로저를 이용해 루프 처리
list.each { item ->
    assert item == list[item]
}

//자바와 동일하게 switch문 사용 가능
switch (3) {
    case 1: assert false; break
    case 3: assert true; break
    default: assert false
}