package chap03.section3.paragraph3.exercise;

//제네릭 클래스의 예
public class GenericClassTester {
    //제네릭 클래스의 파라미터를 T라고 작성합니다.
    static class GenericClass<T> {
        private T xyz;

        public GenericClass(T xyz) {
            this.xyz = xyz;
        }

        public T getXyz() {
            return xyz;
        }
    }

    public static void main(String[] args) {
        GenericClass<String> s = new GenericClass<>("ABC");
        GenericClass<Integer> n = new GenericClass<>(15);

        System.out.println(s.getXyz());
        System.out.println(n.getXyz());
    }
}
