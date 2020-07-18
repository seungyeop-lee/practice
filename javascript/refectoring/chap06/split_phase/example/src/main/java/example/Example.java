package example;

public class Example {
    public static void main(String[] args) {
        try {
            System.out.println(App.run(args));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
