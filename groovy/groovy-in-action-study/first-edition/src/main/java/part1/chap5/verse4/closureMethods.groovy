package part1.chap5.verse4

// 인자 개수에 반응하기
def caller(Closure closure) {
    closure.getParameterTypes().size()
}

assert caller { one -> } == 1
assert caller { one, two -> } == 2


// curry 메서드의 이용
def adder = { x, y -> return x + y }
def addOne = adder.curry(1) // x를 1로 고정시킨 새로운 클로저를 반환
assert addOne(5) == 6


// curry 메서드의 응용 (로그 출력)
// 적용할 설정
def configurator = { format, filter, line ->
    filter(line) ? format(line) : null
}
// 적용할 포멧
def appender = { config, append, line ->
    def out = config(line)
    if (out) {
        append(out)
    }
}
// 필터 클로저
def debugFilter = { line ->
    line.contains('debug')
}
// 포멧 클로저
def dateFormatter = { line ->
    "${new Date()}: $line"
}
// 출력 클로저
def consoleAppender = { line ->
    println line
}

def myConf = configurator.curry(dateFormatter, debugFilter)
def myLog = appender.curry(myConf, consoleAppender)

myLog('here is some debug message')
myLog('this will not be printed')


// isCase 메서드로 분류하기 (grep, switch에서의 클로저 사용)
assert [1,2,3].grep { it < 3 } == [1,2]
switch (10) {
    case { it % 2 == 0 }:
        assert true
        break
    case { it % 2 == 1 }:
        assert false
        break
    default:
        assert false
}