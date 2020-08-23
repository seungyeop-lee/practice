package chap01.section2.paragraph4.practise;

public class Practise13 {
    public static void main(String[] args) {
        System.out.print("   ");
        System.out.print(" |");
        for (int j = 1; j <= 9; j++) {
            System.out.printf("%3d", j);
        }
        System.out.println();

        System.out.print("---");
        System.out.print("-+");
        for (int j = 1; j <= 9; j++) {
            System.out.print("---");
        }
        System.out.println();

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%3d", i);
            System.out.print(" |");
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%3d", i + j);
            }
            System.out.println();
        }
    }
}
