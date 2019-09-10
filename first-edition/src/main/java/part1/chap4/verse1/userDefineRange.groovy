package part1.chap4.verse1

// 사용자 정의 범위 생성
class Weekday implements Comparable {
    static final DAYS = [
        'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'
    ]
    private int index = 0

    Weekday(String day) {
        index = DAYS.indexOf(day)
    }

    // 조건1. next()와 previous()가 각각 정의 되어 있어야 한다.
    // 즉, ++연산자와 --연산자가 재정의 되어있어야 함
    Weekday next() {
        return new Weekday(DAYS[(index+1) % DAYS.size()])   // 오버 플로우 방지용
    }
    Weekday previous() {
        return new Weekday(DAYS[index-1])   // 자동으로 언더 플로우 됨
    }

    // 조건2. Comparable을 구현하여 compareTo()를 재정의 해야한다.
    @Override
    int compareTo(Object other) {
        if(other instanceof Weekday)
            return this.index <=> other.index
    }

    @Override
    String toString() {
        return DAYS[index]
    }
}

def mon = new Weekday('Mon')
def fri = new Weekday('Fri')

def worklog = ''
for (day in mon..fri) { // 범위 사용
    worklog += day.toString() + ' '
}
assert worklog == 'Mon Tue Wed Thu Fri '