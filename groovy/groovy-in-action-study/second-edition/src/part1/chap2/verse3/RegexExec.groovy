package part1.chap2.verse3

// Groovy에서 정규표현식은 /식/ 으로 나타낸다.
assert '12345' =~ /\d+/
assert 'xxxxx' == '12345'.replaceAll(/\d/, 'x')
