package part1.chap7.verse2

import part1.chap7.verse2.thirdparty.MathLib as OrigMathLib
import part1.chap7.verse2.thirdparty.MathLib as TwiceHalfMathLib
import part1.chap7.verse2.thirdparty.MathLib as IncMathLib


class MathLib extends OrigMathLib {
    @Override
    Integer twice(Integer value) {
        return value * 2
    }
}

// 아래의 코드는 바꾸지 않아도 된다.
def mathlib = new MathLib()

assert 10 == mathlib.twice(5)   // 고쳐진 메서드가 호출
assert 2 == mathlib.half(5) // 기존 메서드가 호출


// import as를 이용해 이름 충돌을 피할 수 있다.
def math1 = new TwiceHalfMathLib()
def math2 = new IncMathLib()

assert 3 == math1.half(math2.increment(5))