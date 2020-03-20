package part1.chap6.verse3

// 강력한 그루비 조건문을 이용한 while문

def list = [1,2,3]
while (list) {
    list.remove(0)
}
assert list == []

while (list.size() < 3) {
    list << list.size() + 1
}
assert list == [1,2,3]