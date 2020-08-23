package chap02.section1.paragraph5.practise;

public class Practise5 {
    static void rcopy(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++) {
            a[b.length - i - 1] = b[i];
        }
    }

    public static void main(String[] args) {
        int[] src = {2, 3, 4, 5, 1};
        int[] dst = new int[5];

        rcopy(dst, src);

        for (int v : dst) {
            System.out.print(v + " ");
        }
    }
}
