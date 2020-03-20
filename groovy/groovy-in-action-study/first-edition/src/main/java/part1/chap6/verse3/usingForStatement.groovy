package part1.chap6.verse3

// 자료형 명시, 문자열 범위, 중괄호 없음
def store = ''
for (String i in 'a'..'c') {
    store += i
}
assert store == 'abc'

// 자료형 생략, 리스트 자료형, 중괄호 사용
store = ''
for (i in [1, 2, 3]) {
    store += i
}
assert store == '123'

// 자료형 생략, 한쪽만 포함하는 IntRange, 중괄호 사용
def myString = 'Equivalent to Java'
store = ''
for (i in 0..<myString.size()) {
    store += myString[i]
}
assert store == myString

// 자료형 생략, 문자열 컬렉션, 중괄호 사용
store = ''
for (i in myString) {
    store += i
}
assert store == myString


// 파일의 내용을 한 줄씩 작업
def file = new File('myFileName.txt')
store = ''
for (line in file) {
    store += line
}
assert store == 'This is content of myFileName.txt' +
                'for checking read file' +
                'in \'for statement\''

// 정규 표현식으로 일치하는 문자열을 하나씩 작업
def matcher = '12xy3' =~ /\d/
store = ''
for (match in matcher) {
    store += match
}
assert store == '123'

// 반복할 객체가 null이면 for문은 수행되지 않는다.
for (x in null) {
    assert false
}

// 반복 가능한 객체로 만들 수 없는 경우, 객체 자신을 대상으로 반복하는 방법도 있다.
store = ''
for (x in new Object()) {
    store += "객체 ${x.class}에 대해 한 번만 출력된다."
}
assert store == '객체 class java.lang.Object에 대해 한 번만 출력된다.'