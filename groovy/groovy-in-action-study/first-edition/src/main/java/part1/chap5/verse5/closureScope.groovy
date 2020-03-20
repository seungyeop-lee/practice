package part1.chap5.verse5

class Mother {
    int field = 1
    int foo() {
        return 2
    }
    Closure birth(param) {
        def local = 3
        def closure = { caller ->
            [this, field, foo(), local, param, caller, owner]
        }
        return closure
    }
}

Mother julia = new Mother()

closure = julia.birth(4)

context = closure.call(this)

println context[0].class.name

// 클로저는 생성 될 때의 context의 정보를 전부 가지고 있다.
assert context[1..4] == [1,2,3,4]
assert context[5] instanceof Script
// 클로저 내부의 owner 변수로 클로저가 생성된 context 정보에 접근 가능하다.
assert context[6] instanceof Mother

// {}는 실행될 때 마다 새로운 클로저 객체가 생성된다.
firstClosure = julia.birth(4)
secondClosure = julia.birth(4)
assert false == firstClosure.is(secondClosure)