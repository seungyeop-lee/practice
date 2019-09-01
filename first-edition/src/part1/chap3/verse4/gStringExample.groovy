package part1.chap3.verse4

// 달러 기호를 이용하는 단축 문법
me = 'Tarzan'
you = 'Jane'
line = "me $me - you $you"  // 쌍따옴표(GString)안에서만 단축 문법의 사용이 가능
assert line == 'me Tarzan - you Jane'

// GString은 문자열 내부의 변하는 부분과 변하지 않는 부분이 분리되어 구현되어 있다.
assert line instanceof GString
assert line.strings[0] == 'me ' // 불변 부분
assert line.strings[1] == ' - you '
assert line.values[0] == 'Tarzan'   // 가변 부분
assert line.values[1] == 'Jane'

// 확장된 단축 문법
date = new Date(0)
out = "Year $date.year Month $date.month Day $date.date"    // 단축 문법의 필드 값도 사용이 가능
assert  out == 'Year 70 Month 0 Day 1'

// 중괄호를 사용하는 완전한 문법
out = "Date is ${date.toGMTString()} !" // 중괄호는 클로저를 나타냄
assert out == 'Date is 1 Jan 1970 00:00:00 GMT !'

// 여러 줄 GString
sql = """
SELECT FROM MyTable
    WHERE Year = $date.year
"""
assert sql == """
SELECT FROM MyTable
    WHERE Year = 70
"""

// 달러 기호를 문자열로 쓰려는 경우
out = "my 0.02\$"   // 이스케이프를 사용하여 달러 기호를 표시
assert out == 'my 0.02$'