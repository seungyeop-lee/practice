package chap02.section1.paragraph4.practise;

public class Practise3 {
    static int sumOf(int[] a) {
        int sum = 0;
        for (int v : a) {
            sum += v;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOf(new int[]{2, 3, 4, 1}));
    }
}
