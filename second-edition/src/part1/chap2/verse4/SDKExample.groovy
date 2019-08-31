package part1.chap2.verse4

import java.lang.reflect.Array
import java.util.regex.Matcher
import java.util.regex.Pattern

//그루비의 문자열은 자바의 문자열과 동일하다.
//그러므로 자바 기본 API를 사용하는 것도 가능
if ('Hello World!'.startsWith('Hello')) {
    assert true
} else {
    assert false
}

//그루비에서는 크기에 관련된 메소드를 size()로 통일시켰다.
int[] oneToTen = 1..10
assert oneToTen.length == oneToTen.size()
assert Array.getLength(oneToTen) == oneToTen.size()

assert 'str'.length() == 'str'.size()

StringBuffer sb = new StringBuffer('strBuf')
assert sb.length() == sb.size()

File file = new File('unknown.tmp')
assert file.length() == file.size()

Pattern pattern = Pattern.compile('\\w')
Matcher matcher = pattern.matcher('test')
int count = 0;
while (matcher.find()) count++
assert count == matcher.size()