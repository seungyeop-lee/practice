package part1.chap7.verse2.thirdparty

class MathLib {
    Integer twice(Integer value) {
        return value * 3    // 일부러 틀림
    }

    Integer half(Integer value) {
        return value / 2
    }

    Integer increment(Integer value) {
        return ++value
    }
}
