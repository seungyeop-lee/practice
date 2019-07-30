package part1.chap2.verse3

class Book {
    private String title

    Book(String title) {
        this.title = title
    }

    //메소드의 접근제어자를 생략 할 경우 public이 자동 설정
    String getTitle() {
        return title
    }
}
