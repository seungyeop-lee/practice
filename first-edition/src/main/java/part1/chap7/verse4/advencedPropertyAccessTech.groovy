package part1.chap7.verse4

class DoublerBean {
    public value

    void setValue(value) {
        this.value = value
    }

    def getValue() {
        value * 2
    }
}

def bean = new DoublerBean(value: 100)
assert 200 == bean.value    // getter를 통한 필드 접근
assert 100 == bean.@value   // 필드 직접접근
