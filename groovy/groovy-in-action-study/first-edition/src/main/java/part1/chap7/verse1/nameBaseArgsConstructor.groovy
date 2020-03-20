package part1.chap7.verse1

class Vendor {
    String name, product
}

new Vendor()    // '이름 기반 인자'를 가진 기본 생성자가 인자 없이 호출된 것
new Vendor(name: 'Canoo')
new Vendor(product: 'ULC')
new Vendor(name: 'Canoo', product: 'ULC')

def vendor = new Vendor(name: 'Canoo')
assert 'Canoo' == vendor.name