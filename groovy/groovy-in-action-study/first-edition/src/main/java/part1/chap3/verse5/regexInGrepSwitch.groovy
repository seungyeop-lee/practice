package part1.chap3.verse5

// 패턴과 문자열이 완전히 일치하는지 확인 (실제로는 거의 사용하지 않음)
assert (~/..../).isCase('bear')

// switch문의 case에도 사용이 가능하다!
switch ('bear') {
    case ~/..../:
        assert true
        break
    default:
        assert false
}

beasts = ['bear', 'wolf', 'tiger', 'regex']

// 배열에서 grep메소드를 사용할 경우, 패턴에 맞는 요소만 추출이 가능하다.
assert beasts.grep(~/..../) == ['bear', 'wolf']