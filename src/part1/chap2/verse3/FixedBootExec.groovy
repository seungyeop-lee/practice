package part1.chap2.verse3

def gina = new FixedBook('Groovy in Action')
def regina = new FixedBook(title: 'Groovy in Action')

assert gina.title == 'Groovy in Action'
assert gina == regina

try {
    gina.title = "Oops!"
    assert false, "should not reach here"   //assert의 논리연산 결과의 , 뒤에는 출력 할 메시지를 적을 수 있다.
} catch (ReadOnlyPropertyException expected) {
    println "Expected Error: '$expected.message'"
}