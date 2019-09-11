package part1.chap5.verse3

// 클로저 정의 후 사용
map = ['a':1, 'b':2]
map.each { key, value ->
    map[key] = value * 2
}
assert map == ['a':2, 'b':4]

// 클로저 정의 후 변수 할당
doubler = { key, value ->
    map[key] = value * 2
}
map.each doubler
assert map == ['a':4, 'b':8]

// 메서드 클로저
def doubleMethod(entry) {
    map[entry.key] = entry.value * 2
}
doubler = this.&doubleMethod
map.each doubler
assert map == ['a':8, 'b':16]