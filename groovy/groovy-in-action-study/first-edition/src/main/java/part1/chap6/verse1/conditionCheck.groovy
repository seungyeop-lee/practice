package part1.chap6.verse1

// 가장 기본적 Boolean 값
assert true
assert !false

// Matcher를 이용
assert ('a' =~ /./)
assert !('a' =~ /b/)

// 리스트
assert [1]
assert ![]  // 빈 리스트는 false

// 맵
assert ['a':1]
assert ![:] // 빈 맵은 false

// 문자열
assert 'a'
assert !''  // 빈 문자열은 false

// 숫자
assert 1
assert 1.1
assert 1.2f
assert 1.3g
assert 2L
assert 3G
assert !0   // 0은 false

// 객체
assert new Object()
assert !null    // null은 false