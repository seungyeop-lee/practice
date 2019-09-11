package part1.chap4.verse2

myList = ['a', 'b', 'c', 'd', 'e', 'f']

// 배열의 부분을 반환
// 범위를 이용
assert myList[0..2] == ['a', 'b', 'c']
// 복수의 index 이용
assert myList[0, 2, 4] == ['a', 'c', 'e']

// 범위를 이용한 배열 요소의 치환
myList[0..2] = ['x', 'y', 'z']
assert myList == ['x', 'y', 'z', 'd', 'e', 'f']

// 범위를 이용한 배열 요소의 삭제
myList[3..5] = []
assert myList == ['x', 'y', 'z']

// 범위를 이용한 배열 요소의 삽입
myList[1..1] = ['y', '1', '2']
assert myList == ['x', 'y', '1', '2', 'z']