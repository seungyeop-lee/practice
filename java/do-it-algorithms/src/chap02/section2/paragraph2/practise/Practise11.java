package chap02.section2.paragraph2.practise;

public class Practise11 {
    class YMD {
        int y;
        int m;
        int d;

        public YMD(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        public YMD after(int n) {
            return new YMD(this.y, this.m, this.d + n);
        }

        public YMD before(int n) {
            return new YMD(this.y, this.m, this.d - n);
        }
    }
}
