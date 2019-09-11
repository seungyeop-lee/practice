package part1.chap4.verse2

myList = ['a', 'b', 'c']

// 포함 여부에 따른 분류
assert myList.isCase('a')   // isCase를 정의하고 있으면 grep()과 switch 문에서 사용가능
candidate = 'a'
switch (candidate) {
    case myList:
        assert true
        break
    default:
        assert false
}

// 교집합 필터
assert ['x', 'a', 'z'].grep(myList) == ['a']

// 빈 리스트는 false
myList = []
if (myList) {
    assert false
}

// 리스트와 for 문
log = ''
for (i in [1, 'x', 5]) {
    log += i
}
assert log == '1x5'