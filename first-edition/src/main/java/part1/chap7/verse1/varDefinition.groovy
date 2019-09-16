package part1.chap7.verse1

// 변수 정의 예제

class SomeClass {

    public fieldWithModifier
    String typedField
    def untypedField
    protected field1, field2, field3
    private assignedField = new Date()

    static classField

    public static final String CONSTA = 'a', CONSTB = 'b'
    def someMethod() {
        def localUntypedMethodVar = 1
        int localTypedMethodVar = 1
        def localVarWithoutAssignment, andAnotherOne
    }

    final static String PI = 3.14
}

def localvar = 1
boundVar1 = 1

def someMethod() {
    localMethodVar = 1
    boundVar2 = 1
}

assert SomeClass.PI.class.name == 'java.lang.String'
assert SomeClass.PI.length() == 4
new GroovyTestCase().shouldFail(ClassCastException.class) {
    Float areaOfCircleRediousOne = SomeClass.PI
}