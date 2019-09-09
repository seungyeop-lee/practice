package part1.chap3.verse6

def store = ''
10.times {  // 반복
    store += 'x'
}
assert store == 'xxxxxxxxxx'

store = ''
1.upto(5) { number ->   // 반복문 내의 증가 변수
    store += number
}
assert store == '12345'

store = ''
2.downto(-2) { number ->    // 반복문 내의 감소 변수
    store += number + ' '
}
assert store == '2 1 0 -1 -2 '

store = ''
0.step(0.5, 0.1) { number ->    // 지정된 간격으로 증감
    store += number + ' '
}
assert store == '0 0.1 0.2 0.3 0.4 '