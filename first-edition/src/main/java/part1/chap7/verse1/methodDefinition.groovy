package part1.chap7.verse1

class SomeClassForMethodDefinition {

    static main(args) {
        def some = new SomeClassForMethodDefinition()
        some.publicVoidMethod()
        assert 'hi' == some.publicUntypedMethod()
        assert 'ho' == some.publicTypedMethod()
        combinedMethod()
    }

    void publicVoidMethod() {
    }

    def publicUntypedMethod() {
        return 'hi'
    }

    String publicTypedMethod() {
        return 'ho'
    }

    protected static final void combinedMethod() {
    }

}