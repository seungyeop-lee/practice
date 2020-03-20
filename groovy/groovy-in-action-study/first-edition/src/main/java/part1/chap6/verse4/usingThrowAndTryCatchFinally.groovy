package part1.chap6.verse4


def myMethod() {
    throw new IllegalArgumentException()
}

// 자바에서의 필수 선언 예외 처리 방법
def log = []
try {
    myMethod()
} catch (Exception e) {
    log << e.toString()
} finally {
    log << 'finally'
}
assert log.size() == 2

// 그루비에서는 try-catch문이 필요가 없다. (RuntimeException처럼 상위 호출스택에 예외를 던진다.)
myMethod()