package chap01.section1.paragraph1.practise;

public class Practice1 {
    static int max4(int a, int b, int c, int d) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        return max;
    }

    public static void main(String[] args) {
        System.out.println("max4(1,2,3,4) = " + max4(1, 2, 3, 4));
        System.out.println("max4(4,3,2,1) = " + max4(4, 3, 2, 1));
        System.out.println("max4(4,4,4,4) = " + max4(4, 4, 4, 4));
    }
}
