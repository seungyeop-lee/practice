package part1.chap7.verse6

import org.codehaus.groovy.runtime.StringBufferWriter

class Whatever {
    int outer() {
        return inner()
    }
    int inner() {
        return 1
    }
}

def log = new StringBuffer("/n")
def tracer = new TracingInterceptor()
tracer.writer = new StringBufferWriter(log)
def proxy = ProxyMetaClass.getInstance(Whatever.class)
proxy.interceptor = tracer
proxy.use {
    assert 1 == new Whatever().outer()
}

// 버전의 차이로 인해 """ 안에서의 줄 바꿈은 띄어쓰기로 인식, 그래서 같지 않게 됨
assert log.toString() == """
before part1.chap7.verse6.Whatever.ctor()
after  part1.chap7.verse6.Whatever.ctor()
before part1.chap7.verse6.Whatever.outer()
 before part1.chap7.verse6.Whatever.inner()
 after  part1.chap7.verse6.Whatever.inner()
after  part1.chap7.verse6.Whatever.outer()
"""