package part1.chap4.verse3

// 요소 전체 삭제
def myMap = [a:1, b:2, c:3]
myMap.clear()
assert myMap.isEmpty()

// 요소 삭제
myMap = [a:1, b:2, c:3]
myMap.remove('a')
assert myMap.size() == 2

// 인수로 주어진 값을 키로하는 값들로 하위 맵을 생성
myMap = [a:1, b:2, c:3]
def abMap = myMap.subMap(['a', 'b'])
assert abMap.size() == 2

// 조건에 맞는 키-값만을 가진 새로운 맵 반환
def found = myMap.findAll { entry ->
    entry.value < 2
}
assert found.size() == 1
assert found.a == 1

// 모든 요소에 대해 계산 후 결과를 리스트로 반환
def doubled = myMap.collect { entry ->
    entry.value *= 2
}
assert doubled instanceof List
assert doubled.every { item ->
    item % 2 == 0
}

// 모든 요소에 대해 계산, 인자로 누산기를 설정
def addTo = []
myMap.collect(addTo) { entry ->
    entry.value *= 2
}
assert addTo instanceof List
assert addTo.every { item ->
    item % 2 == 0
}