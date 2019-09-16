package part1.chap7.verse4

class MrBean {
    String firstname, lastname  // 그루비 스타일 프로퍼티

    String getName() {  // 가상 프로퍼티의 생성자 (name이라는 읽기전용 프로퍼티가 생성)
        return "$firstname $lastname"
    }
}

def bean = new MrBean(firstname: 'Rowan')   // 생성자
bean.lastname = 'Atkinson'  // 쓰기 접근자 호출

assert 'Rowan Atkinson' == bean.name    // 읽기 접근자 호출