package part1.chap7.verse4

class MyBean implements Serializable {
    // 기본 접근 권한의 필드 변수들은 자동으로 프로퍼티가 된다.
    def untyped
    String typed
    def item1, item2
    def assigned = 'default value'
}

def bean = new MyBean()
// 기본값 획득
assert 'default value' == bean.getAssigned()
// set 후 get
bean.setUntyped('some value')
assert 'some value' == bean.getUntyped()
// 이름 기반 인자를 이용한 필드 초기화
bean = new MyBean(typed: 'another value')
assert 'another value' == bean.getTyped()