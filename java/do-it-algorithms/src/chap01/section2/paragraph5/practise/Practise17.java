package chap01.section2.paragraph5.practise;

public class Practise17 {
    static void npira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
                System.out.print(i % 10);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        npira(20);
    }
}
