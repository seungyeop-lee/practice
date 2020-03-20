package part1.chap6.verse2

def a = 1
def log = ''
// 흘러내리기가 포함 된 switch 문 (일반적인 switch 문)
switch (a) {
    case 0:
        log += '0'
    case 1:
        log += '1'
    case 2:
        log += '2'
        break
    default:
        log += 'default'
}
assert log == '12'


def candidate = 'candidate'
def classifier1 = 'classifier1'
def classifier2 = 'classifier2'
def void handle1() {}
def void handle2() {}
def void handleDefault() {}

// 그루비에서의 switch와 if-elseif-else의 유사성
switch (candidate) {
    case classifier1:
        handle1()
        break
    case classifier2:
        handle2()
        break
    default:
        handleDefault()
}

if (classifier1.isCase(candidate)) handle1()
else if (classifier2.isCase(candidate)) handle2()
else handleDefault()


// 다양한 분류자를 이용한 switch 문
switch (10) {
    case 0:
        assert false
        break
    case 0..9:  // 범위로 분류
        assert false
        break
    case [8,9,11]:  // 리스트로 분류
        assert false
        break
    case Float: // 자료형으로 분류
        assert false
        break
    case { it % 3 == 0 }:   // 클로저로 분류
        assert false
        break
    case ~/../: // 정규 표현식으로 분류
        assert true
        break
    default:
        assert false
        break
}