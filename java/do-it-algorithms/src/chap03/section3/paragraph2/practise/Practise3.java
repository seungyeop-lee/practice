package chap03.section3.paragraph2.practise;

public class Practise3 {
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int ptr = 0;
        int foundCount = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                idx[ptr++] = i;
                foundCount++;
            }
        }
        return foundCount;
    }

    public static void main(String[] args) {
        int[] target = new int[]{1, 9, 2, 9, 4, 6, 7, 9};
        int[] found = new int[10];
        int foundCount = searchIdx(target, target.length, 9, found);
        System.out.println("foundCount: " + foundCount);
        for (int n : found) {
            System.out.printf("%d ", n);
        }
    }
}
