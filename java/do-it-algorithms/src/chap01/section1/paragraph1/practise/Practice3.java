package chap01.section1.paragraph1.practise;

public class Practice3 {
    static int min4(int a, int b, int c, int d) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        return min;
    }
    public static void main(String[] args) {
        System.out.println("min4(1,2,3,4) = " + min4(1, 2, 3, 4));
        System.out.println("min4(4,3,2,1) = " + min4(4, 3, 2, 1));
        System.out.println("min4(4,4,4,4) = " + min4(4, 4, 4, 4));
    }
}
