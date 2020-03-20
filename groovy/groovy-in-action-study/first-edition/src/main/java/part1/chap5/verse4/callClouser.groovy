package part1.chap5.verse4

// 클로저의 실행
def adder = { x, y ->
    return x + y
}
assert adder(4, 3) == 7
assert adder.call(2, 6) == 8

// 클로저의 사용 예제
def benchmark(repeat, Closure worker) {
    start = System.currentTimeMillis()
    repeat.times { worker(it) }
    stop = System.currentTimeMillis()
    return stop - start
}
slow = benchmark(10000) { (int) it / 2 }
fast = benchmark(10000) { it.intdiv(2) }
assert fast * 3 < slow

// 클로저의 파라미터에 인자가 없을 경우의 디폴트 값을 설정 할 수 있다.
adder = { x, y = 5 ->
    return x + y
}
assert adder(4, 3) == 7
assert adder.call(7) == 12