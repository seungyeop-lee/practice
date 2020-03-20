package part1.chap7.verse1

class VendorWithCtor {
    String name, product

    VendorWithCtor(name, producet) {
        this.name = name
        this.product = producet
    }
}

def first = new VendorWithCtor('Canoo', 'ULC')

// 리스트를 어떤 클래스로 형 변환 할 때, 클래스의 생성자를 호출하고 인자로 리스트의 요소를 차례대로 설정한다.
// 명시적 형변환
def second = ['Canoo', 'ULC'] as VendorWithCtor

// 암묵적 형변환
VendorWithCtor third = ['Canoo', 'ULC']

assert first.name == second.name
assert second.name == third.name