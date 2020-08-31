package chap02.section1.paragraph6.practise;

public class Practise6 {
    static int cardConv(int x, int r, char[] d) {
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        int totalDigits = 0;
        int no = x;
        int cd = r;
        do {
            totalDigits++;
            no /= cd;
        } while (no != 0);

        int digits = 0;
        do {
            digits++;
            d[totalDigits - digits] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        return digits;
    }

    public static void main(String[] args) {
        char[] cno = new char[32];
        cardConv(100, 10, cno);
        System.out.println(cno);
    }
}
