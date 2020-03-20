package part1.chap6.verse2

// if 문의 기초적 사용
if (true) assert true
else assert false

// 조건문으로 다른 객체가 들어와도 된다.
if (1) {
    assert true
} else {
    assert false
}

// 비어있지 않는 문자열은 true
if ('non-empty') assert true
else assert false
// 비어있지 않는 리스트는 true
if (['x']) assert true
else assert false

// 0과 빈 리스트는 false
if (0) assert false
else if ([]) assert false
else assert true
