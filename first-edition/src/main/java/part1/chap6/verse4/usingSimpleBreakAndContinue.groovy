package part1.chap6.verse4

// 단순한 break와 continue

def a = 1
while (true) {  // 무한루프
    a++
    break   // 루프 중지
}
assert a == 2

for (i in 0..10) {
    if (i == 0) continue    // 더 진행하지 않고, 다음 i로 반복문 되풀이
    a++
    if (i > 0) break    // 루프 중지
}
assert a == 3