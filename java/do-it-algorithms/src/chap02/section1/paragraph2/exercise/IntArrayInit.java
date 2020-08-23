package chap02.section1.paragraph2.exercise;

public class IntArrayInit {
    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5}; 와 동일
        int[] a = new int[]{1, 2, 3, 4, 5};

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
