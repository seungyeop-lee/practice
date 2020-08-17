package chap01.section2.paragraph1.practise;

import java.util.Scanner;

public class Practise9 {
    static int sumof(int a, int b) {
        int min, max;
        if (a > b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("n부터 m까지의 합을 구합니다.");
        System.out.print("n의 값: ");
        int n = stdIn.nextInt();
        System.out.print("m의 값: ");
        int m = stdIn.nextInt();

        int result = sumof(n, m);

        System.out.println(n + "부터 " + m + "까지의 합은 " + result + "입니다.");
    }
}
