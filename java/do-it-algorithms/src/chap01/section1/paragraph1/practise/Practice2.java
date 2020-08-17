package chap01.section1.paragraph1.practise;

public class Practice2 {
    static int min3(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }
    public static void main(String[] args) {
        System.out.println("min3(1,2,3) = " + min3(1,2,3));
        System.out.println("min3(3,2,1) = " + min3(3,2,1));
        System.out.println("min3(3,3,3) = " + min3(3,3,3));
    }
}
