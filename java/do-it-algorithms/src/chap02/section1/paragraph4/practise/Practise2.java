package chap02.section1.paragraph4.practise;

public class Practise2 {
    public static void main(String[] args) {
        int[] x = {5, 10, 73, 2, -5, 42};

        reverse(x);
    }

    static void reverse(int[] a) {
        printArray(a);
        for (int i = 0; i < a.length / 2; i++) {
            System.out.printf("a[%d]와(과) a[%d]를 교환합니다.\n", i, a.length - i - 1);
            swap(a, i, a.length - i - 1);
            printArray(a);
        }
        System.out.println("역순 정렬을 마쳤습니다.");
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }
}
