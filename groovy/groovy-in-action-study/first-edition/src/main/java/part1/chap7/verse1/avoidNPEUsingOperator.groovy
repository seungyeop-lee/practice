package part1.chap7.verse1

def map = [a:[b:[c:1]]]

assert map.a.b.c == 1

// if를 이용해 평가식에서 피하기
if (map && map.a && map.a.x) {
    assert map.a.x.c == null
}

// try/catch로 피하기
try {
    assert map.a.x.c == null
} catch (NullPointerException npe) {
}

// 안전 참조롤 피하기
assert map?.a?.x?.c == null