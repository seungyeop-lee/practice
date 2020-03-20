package part1.chap4.verse3

def myMap = [a:1, b:2, c:3]

// 맵에서 요소를 얻는 다양한 방법
assert myMap['a'] == 1
assert myMap.a == 1
assert myMap.get('a') == 1
assert myMap.get('a', 0) == 1

// 맵에서 없는 요소를 얻으려고 할 경우 null 반환
assert myMap['d'] == null
assert myMap.d == null
assert myMap.get('d') == null

// 요소가 없는 경우 값을 설정하면서 요소 얻기
assert myMap.get('d', 0) == 0
assert myMap.d == 0

// 요소를 할당하기
myMap['d'] = 1
assert myMap.d == 1
myMap.d = 2
assert myMap.d == 2

// 키에 특수문자가 있는 경우의 도트-키 문법
myMap = ['a.b':1]
assert myMap.'a.b' == 1