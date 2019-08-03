package part1.chap3.verse1

assert 15 instanceof Integer
assert 0x1234ffff instanceof Integer
assert 0b00110011 instanceof Integer
assert 100_000_000 instanceof Integer

assert 100L instanceof Long
assert 200l instanceof Long

assert 1.23f instanceof Float
assert 4.56F instanceof Float

assert 1.23d instanceof Double
assert 4.56D instanceof Double

assert 123g instanceof BigInteger
assert 456G instanceof BigInteger

assert 1.23 instanceof BigDecimal
assert 1.4E4 instanceof BigDecimal
assert 2.8e4 instanceof BigDecimal
assert 1.23g instanceof BigDecimal
assert 1.23G instanceof BigDecimal
