package part1.chap2.verse3

// 그루비빈 형태 클래스
class GBBook {
    String title
}

def groovyBook = new GBBook();

// 자동으로 필드의 set, get메소드가 생성 된다.
groovyBook.setTitle('Groovy conquers the world')
assert groovyBook.getTitle() == 'Groovy conquers the world'

// 직접 접근하여 값의 조회 및 수정도 가능하다.
groovyBook.title = 'Groovy in Action'
assert groovyBook.title == 'Groovy in Action'