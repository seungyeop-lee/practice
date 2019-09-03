package part1.chap2.verse3

// 스크립트 형식으로 작성하여 실행이 가능하다.

// 새미콜론 생략이 가능하다.
Book gina = new Book('Groovy in Action')

assert gina.getTitle() == 'Groovy in Action'
// 뒤에 선언 및 정의한 메소드를 앞에서 사용 가능하다.
// 그루비는 일반적인 스크립트언어와 다르게 내부적으로는 컴파일 후 실행
assert getTitleBackwards(gina) == 'noitcA ni yvoorG'

String getTitleBackwards(book) {
    title = book.getTitle()
    return title.reverse()
}