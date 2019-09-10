package part1.chap4.verse1

// 범위 + each(clojure)
result = ''
(5..9).each { element ->
    result += element
}
assert result == '56789'

// 범위 안 값 검사
assert (0..10).isCase(5)
assert (0..10).contains(5)

// switch-case + 범위
age = 36
switch (age) {
    case 16..20:
        insuranceRate = 0.05
        break
    case 21..50:
        insuranceRate = 0.06
        break
    case 51..65:
        insuranceRate = 0.07
        break
    default:
        throw new IllegalArgumentException()
}
assert insuranceRate == 0.06

// 범위를 필터로 사용
ages = [20, 36, 41, 56]
midage = 21..50
assert ages.grep(midage) == [36, 41]