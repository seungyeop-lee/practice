package lspExample;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(10, 10, 10);
        resize(square, 50, 100);
    }

    private static void resize(Rectangle rectangle, int width, int height) {
        //정사각형의 경우, set메서드에서 width와 height를 동시에 변경하고 있다.
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        //그러므로 항상 아래의 단정문을 만족시키지 못하게 된다.
        assert rectangle.getWidth() == width && rectangle.getHeight() == height;
    }
}
