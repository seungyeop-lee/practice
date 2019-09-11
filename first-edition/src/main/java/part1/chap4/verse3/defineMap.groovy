package part1.chap4.verse3

// 일반적인 맵 정의
def myMap = [a:1, b:2, c:3]

assert myMap instanceof HashMap
assert myMap.size() == 3
assert myMap['a'] == 1

// 빈 맵 정의
def emptyMap = [:]
assert emptyMap.size() == 0

// HashMap 이외의 맵 정의
def explicitMap = new TreeMap()
explicitMap.putAll(myMap)
assert explicitMap['a'] == 1