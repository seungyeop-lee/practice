package part1.chap7.verse1

class Counter {
    public count = 0
}

def counter = new Counter()

// 참조 연산자(.)로 필드 변수에 접근
counter.count = 1
assert counter.count == 1

// 배열 첨자 연산자([])로 필드 변수에 접근
def fieldName = 'count'
counter[fieldName] = 2
assert counter['count'] == 2