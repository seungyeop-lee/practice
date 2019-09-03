package part1.chap3.verse5

myFairStringy = 'The rain in Spain stays mainly in the plain!'

// 'ain'으로 끝나는 단어에 대한 정규표현식 == \b\W*ain\b
BOUNDS = /\b/
rhyme = /$BOUNDS\w*ain$BOUNDS/
found = ''
myFairStringy.eachMatch(rhyme) { match ->   // match에는 해당 문자열이 설정
    found += match + ' '
}
assert found == 'rain Spain plain '

found = ''
(myFairStringy =~ rhyme).each { match ->
    found += match + ' '
}
assert found == 'rain Spain plain '

cloze = myFairStringy.replaceAll(rhyme) { it - 'ain' + '___' }  // 해당 문자열에 ain을 제거하고, ___을 삽입
assert cloze == 'The r___ in Sp___ stays mainly in the pl___!'

// GDK는 Matcher 클래스의 내부정보를 배열 처럼 사용 가능하게 확장
matcher = 'a b c' =~ /\S/

assert matcher[0] == 'a'
assert matcher[1..2] == 'bc'
assert matcher.count == 3

// 정규표현식에 그룹(괄호)이 있는 경우 Matcher에서는 배열을 반환한다.
// 즉, 패턴의 그룹유무에 따라 matcher[0] 값이 달라진다.
matcher = 'a:1 b:2 c:3' =~ /(\S+):(\S+)/

assert matcher.hasGroup()
assert matcher[0] == ['a:1', 'a', '1']  // 전체 영역, 그룹1, 그룹2

// 그룹이 있는 경우 each 메서드에서도 매개변수로 각 그룹의 값을 받아 사용가능하다.
('xy' =~ /(.)(.)/).each { all, x, y ->
    assert all == 'xy'
    assert x == 'x'
    assert y == 'y'
}