package part1.chap3.verse2

class TypeSafeDynamicGroovy {
    static void main(String[] args) {
        //리턴타입을 명시 할 수도 있고, def로 추론을 하게 할 수도 있다.
        String greeting1 = readFromConsole()
        def greeting2 = readFromConsole()

        // 정의부와 선언부의 타입이 다를경우 강제 형변환을 시도
//        Integer myInt = new Object()    //GroovyCastException 발생
//        Integer myInt = (Integer) new Object()    //위 코드의 java 버전

//        printNext(new Object()) // MissingMethodException 발생 (인수로 Object를 받는 메소드는 없음)
    }

    static String readFromConsole() {
        def s = new Scanner(System.in)
        s.next()
    }

    static def printNext(Integer myInt) {
        println(++myInt)
    }

}
