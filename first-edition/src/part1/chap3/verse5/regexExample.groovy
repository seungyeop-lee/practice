package part1.chap3.verse5

twister = 'she sells sea shells at the sea shore of seychelles'

// twister에는 s로 시작하고 a로 끝나는 세자리 단어가 있다.
assert twister =~ /s.a/ // 검색연산자

finder = (twister =~ /s.a/)
assert finder instanceof java.util.regex.Matcher    // 검색연산자는 Matcher객체를 반환한다.

// twister의 단어들 사이에는 공백이 한 칸씩만 있다.
assert twister ==~ /\w+( \w+)*/ // 일치연산자

WORD = /\w+/
matches = (twister ==~ /($WORD $WORD)*/)
assert matches instanceof java.lang.Boolean // 일치연산자는 Boolean객체를 반환한다.

assert (twister ==~ /s.e/) == false // 일치연산자는 문자열 전체와 비교를 한다.

wordsByX = twister.replaceAll(WORD, 'x')    // 정규표현식과 일치하는 부분을 전부 치환한다.
assert wordsByX == 'x x x x x x x x x x'

words = twister.split(/ /)  // 인자를 정규표현식으로 사용하여 문자열을 자른다.
assert words.size() == 10
assert words[0] == 'she'