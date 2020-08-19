package chap01.section2.paragraph2.practise;

import java.util.Scanner;

public class Practise11 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("자릿수를 출력합니다.");
        System.out.print("숫자: ");
        int num = stdIn.nextInt();

        String numStr = String.valueOf(num);
        int length = numStr.length();

        System.out.println("그 수는 " + length + "자리입니다.");
    }
}
