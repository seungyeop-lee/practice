package chap01.section2.paragraph1.practise;

import java.util.Scanner;

public class Practise6 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값: ");
        int n = stdIn.nextInt();

        int sum = 0;
        int i = 1;

        while (i <= n) {
            sum += i;
            i++;
        }
        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
        System.out.println("계산에 사용된 i의 값은 " + i + "입니다.");
    }
}
