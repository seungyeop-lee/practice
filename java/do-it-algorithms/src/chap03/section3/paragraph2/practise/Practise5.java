package chap03.section3.paragraph2.practise;

public class Practise5 {
    static int binSearchX(int[] a, int n, int key) {
        int result = -1;
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                result = pc;
            }

            if (a[pc] < key) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);

        return result;
    }

    public static void main(String[] args) {
        int[] x = new int[]{1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
        int ky = 7;

        int idx = binSearchX(x, x.length, ky);

        if (idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
        }
    }
}
