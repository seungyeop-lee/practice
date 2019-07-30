package part1.chap2.verse3

//Maven이나 Gradle이 없이 즉시 필요한 의존성을 추가해 준다.
@Grab(group = 'commons-lang', module = 'commons-lang', version = '2.4')
import org.apache.commons.lang.ClassUtils

assert !ClassUtils.isInnerClass(Outer)
assert ClassUtils.isInnerClass(Outer.Inner)
println 'all assert is passed'