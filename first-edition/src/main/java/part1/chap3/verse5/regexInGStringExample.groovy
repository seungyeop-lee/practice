package part1.chap3.verse5

// GString에서 패턴 정의하기
assert "abc" == /abc/   // 슬래시 표기법은 GString과 기본적으로 동일
assert "\\d" == /\d/    // 슬래시 표기법에서는 역슬러시를 1번만 써도 적용 됨 (가독성 향상)

def reference = "hello"
assert reference == /$reference/    // 달러 기호를 이용한 단축 문법 사용도 가능

assert "\$" == /$/  // 정규표현식의 $의 의미로 사용하는 경우 이스케이프 문자를 쓰지 않아도 된다.