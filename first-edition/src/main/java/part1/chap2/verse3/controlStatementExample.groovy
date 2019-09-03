package part1.chap2.verse3

// 한줄 if문
if(false) assert false

// null을 이용한 if문
if(null) {  // null을 false로 인식
    assert false
} else {
    assert true
}

// 고전적인 while문
def i = 0;
while(i < 10) {
    i++
}
assert i == 10

// 범위를 이용한 for-in문
def clinks = 0
for(remainingGuests in 0..9) {
    clinks += remainingGuests
}
assert clinks == (10 * 9) / 2

// 리스트의 for문
def list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
for (j in list) {
    assert j == list[j]
}

// 리스트의 each메소드 (클로저 이용)
list.each { item ->
    assert item == list[item]
}

// 고전적인 switch문
switch (3) {
    case 1:
        assert false
        break
    case 3:
        assert true
        break
    default:
        assert false
}
