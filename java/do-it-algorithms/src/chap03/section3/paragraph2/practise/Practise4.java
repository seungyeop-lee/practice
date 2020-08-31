package chap03.section3.paragraph2.practise;

import java.util.Scanner;

public class Practise4 {
    static int binSearch(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;
        int pc;

        printHeader(n);
        do {
            printPtr(n, pl, pr);
            pc = (pl + pr) / 2;
            if (a[pc] == key) {
                printArray(a, n, pc);
                return pc;
            } else if (a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
            printArray(a, n, pc);
        } while (pl <= pr);

        return -1;
    }

    private static void printArray(int[] a, int n, int pc) {
        System.out.printf("%4d|", pc);
        for (int i = 0; i < n; i++) {
            System.out.printf("%4d", a[i]);
        }
        System.out.println();
    }

    private static void printPtr(int n, int pl, int pr) {
        int pc = (pl + pr) / 2;
        System.out.print("    |");
        for (int i = 0; i < n; i++) {
            if (i == pc) {
                System.out.print("   +");
            } else if(i == pl) {
                System.out.print("  <-");
            } else if(i == pr) {
                System.out.print("  ->");
            } else {
                System.out.print("    ");
            }
        }
        System.out.println();
    }

    private static void printHeader(int n) {
        System.out.print("    |");
        for (int i = 0; i < n; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        System.out.println("----+-------------------------------");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);
        }

        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();

        int idx = binSearch(x, num, ky);

        if (idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
        }
    }
}
