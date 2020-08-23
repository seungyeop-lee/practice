package chap02.section1.paragraph5.practise;

public class Practise4 {
    static void copy(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }
    }

    public static void main(String[] args) {
        int[] src = {2, 3, 4, 5, 1};
        int[] dst = new int[5];

        copy(dst, src);

        for (int v : dst) {
            System.out.print(v + " ");
        }
    }
}
