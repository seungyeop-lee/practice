package part1.chap4.verse3

def myMap = [a:1, b:2, c:3]
def other = [b:2, c:3, a:1]

// 맵은 정의 시 순서와는 관계없음
assert myMap == other

// JDK Map 인터페이스의 메서드
assert myMap.isEmpty() == false
assert myMap.size() == 3
assert myMap.containsKey('a')
assert myMap.containsValue(1)
assert myMap.keySet() == toSet(['a','b','c'])
assert toSet(myMap.values()) == toSet([1,2,3])
assert myMap.entrySet() instanceof Collection

// GDK 에 추가 된 메서드
assert myMap.any { entry ->
    entry.value > 2
}
assert myMap.every { entry ->
    entry.key < 'd'
}

// 검증용 메서드
def toSet(list) {
    new HashSet(list)
}