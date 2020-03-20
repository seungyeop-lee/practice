package part1.chap4.verse3

def myMap = [a:1, b:2, c:3]

// entry 를 파라미터로 반복
def store = ''
myMap.each { entry ->
    store += entry.key
    store += entry.value
}
assert store.contains('a1')
assert store.contains('b2')
assert store.contains('c3')

// key 와 value 를 파라미터로 반복
store = ''
myMap.each {key, value ->
    store += key
    store += value
}
assert store.contains('a1')
assert store.contains('b2')
assert store.contains('c3')

// key 값 만으로 반복
store = ''
for (key in myMap.keySet()) {
    store += key
}
assert store.contains('a')
assert store.contains('b')
assert store.contains('c')

// value 값 만으로 반복
store = ''
for (value in myMap.values()) {
    store += value
}
assert store.contains('1')
assert store.contains('2')
assert store.contains('3')