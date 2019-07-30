package part1.chap2.verse2

/*
groovy에서는 java보다 더 강력한 assert문을 지원한다.
 */
assert(true)    //true일 경우 통과

assert 1 == 1   //논리연산의 결과로 true가 나올 경우 통과

def x = 1
assert x == 1   //변수 사용 가능
def y = 1; assert y == 1    //한줄에 2개 이상의 구문을 사용하기 위해선 ; 가 필요

def str1 = new String('test')
def str2 = new String('test')
assert str1 == str2 //문자열도 내용이 같다면 true

println 'all assert passed!'

//assert의 논리연산 결과가 false일 경우 자세한 사항을 출력
def a = 1
def b = 5
assert a == b + b
/*
    Assertion failed:

    assert a == b + b
           | |  | | |
           1 |  5 | 5
             |    10
             false
 */