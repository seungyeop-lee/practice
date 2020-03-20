package part1.chap3.verse5

twister = 'she sells sea shells at the sea shore of seychelles'

// 약간 복잡한 정규 표현식:
// 처음과 끝 글자가 같은 단어들
regex = /\b(\w)\w*\1\b/ // \1은 앞에서 설정한 그룹에 걸린 문자열로 치환된다. (빅매치)

start = System.currentTimeMillis()
100000.times {
    twister =~ regex    // 암시적 패턴 생성을 이용한 검색 연산
}
first = System.currentTimeMillis() - start

start = System.currentTimeMillis()
pattern = ~regex    // 패턴의 명시적 생성
100000.times {
    pattern.matcher(twister)
}
second = System.currentTimeMillis() - start

assert first > second * 1.20    // 명시적 생성이 암시적 생성에 비해 20%이상 더 빠르다.