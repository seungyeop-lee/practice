package court

class Player {
    //도메인간의 상관관계 설정
    static hasMany = [ reservations: Reservation ]  //Player가 Reservation을 많이 가지고 있음(일 대 다 관계)임을 의미

    String name
    String phone

    //도메인 클래스의 제약조건 설정
    static constraints = {
        name(blank: false)  //공백일 수 없고, 필숫값임을 의미
        phone(blank: false)
    }

}
