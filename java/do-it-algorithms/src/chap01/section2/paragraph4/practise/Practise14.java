package chap01.section2.paragraph4.practise;

import java.util.Scanner;

public class Practise14 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("사각형을 출력합니다.");
        System.out.print("단 수: ");

        n = stdIn.nextInt();

        for (int i = 1; i <= n; ++i) {
            for(int j = 1; j <= n; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
