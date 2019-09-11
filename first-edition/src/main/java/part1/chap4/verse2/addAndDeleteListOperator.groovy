package part1.chap4.verse2

myList = []

// 요소의 추가
myList += 'a'   // plus(Object)
assert myList == ['a']

myList += ['b', 'c']    // plus(Collection)
assert myList == ['a', 'b', 'c']

myList = []
myList << 'a' << 'b'    // append(Object)
assert myList == ['a', 'b']

assert myList - ['b'] == ['a']  // minus(Collection)

assert myList * 2 == ['a', 'b', 'a', 'b']   // multiply(Number)