package court

//관례에 따라 welcome에 매핑
class WelcomeController {
    //welcome아래의 index에 매핑
    def index() {   //def를 리턴타입으로 지정 할 경우 자동으로 타입지정
        Date now = new Date()
        [today:now] //마지막 구문이 자동으로 리턴 됨, 스프링의 모델에 해당
    }
}
