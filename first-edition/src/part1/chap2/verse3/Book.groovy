package part1.chap2.verse3

// 그루비로 만든 클래스
class Book {
    private String title

    Book(String theTitle) {
        title = theTitle
    }

    // 메소드의 접근제어자가 없다.
    String getTitle() {
        return title
    }
}
