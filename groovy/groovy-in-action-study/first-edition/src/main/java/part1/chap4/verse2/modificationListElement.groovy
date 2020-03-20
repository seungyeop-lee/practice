package part1.chap4.verse2

// 평탄하게 한 리스트를 반환
assert [1,[2,3]].flatten() == [1,2,3]

// 리스트의 교집합 반환
assert [1,2,3].intersect([4,3,1]) == [3,1]
// 두 리스트가 공집합이면 true, 교집합이면 false
assert [1,2,3].disjoint([4,5,6])

// 스택처럼 사용
list = [1,2,3]
popped = list.pop()
assert popped == 1
assert list == [2,3]

// 역순의 리스트 반환
assert [1,2].reverse() == [2,1]

// 정렬된(오름차순) 리스트 반환
assert [3,1,2].sort() == [1,2,3]    // 내부적으로 Comparable 인터페이스의 구현이 필요

// 클로저를 이용한 정렬 (Comparator)
def list = [ [1,0], [0,1,2] ]
list = list.sort { a,b -> a[0] <=> b[0] }
assert list == [ [0,1,2], [1,0] ]

// 클로저를 이용한 정렬 (정렬 기준의 숫자)
list = list.sort { item -> item.size() }
assert list == [ [1,0], [0,1,2] ]

// 리스트의 요소 삭제
list = ['a', 'b', 'c']
list.remove(2)  // 인덱스 이용
assert list == ['a', 'b']
list.remove('b')    // 요소 이용
assert list == ['a']

// 리스트를 이용한 복수의 요소 삭제
list = ['a', 'b', 'b', 'c']
list.removeAll(['b', 'c'])
assert list == ['a']

// 변환된 리스트의 반환
def doubled = [1,2,3].collect { item ->
    item * 2
}
assert doubled == [2,4,6]

// 클로저를 만족하는 요소로 이루어진 배열의 반환
def odd = [1,2,3].findAll { item ->
    item % 2 == 1
}
assert odd == [1,3]

// 중복 값 제거
def x = [1,1,1]
assert [1] == new HashSet<>(x).toList()
assert [1] == x.unique()

// null 값 제거
x = [1,null,1]
assert [1,1] == x.findAll { it != null }
assert [1,1] == x.grep { it }