package part1.chap4.verse2

// 리스트의 조사
def list = [1,2,3]

assert list.count(2) == 1
assert list.max() == 3
assert list.min() == 1

def even = list.find { item ->  // 조건에 맞는 첫번째 요소를 반환
    item % 2 == 0
}
assert even == 2

assert list.every { item -> item < 5 }  // 모든 요소가 조건에 맞으면 true
assert list.any { item -> item < 2 }    // 요소 중 1개라도 조건에 맞으면 true

// 리스트의 반복
def store = ''
list.each { item -> // 모든 요소에 대해 반복
    store += item
}
assert store == '123'

store = ''
list.reverseEach { item ->  // 모든 요소에 대해 반복 (역순)
    store += item
}
assert store == '321'

assert list.join('-') == '1-2-3'    // 모든 요소를 인수로 설정된 문자열로 연결

// 리스트의 누산
result = list.inject(0) { clinks, guests -> // 인수로 설정된 값을 기준으로 요소를 누적
    clinks += guests
}
assert result == 0 + 1+2+3
assert list.sum() == 6

factorial = list.inject(1) { fac, item ->
    fac *= item
}
assert factorial == 1 * 1*2*3