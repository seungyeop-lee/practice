package part1.chap7.verse4

class SomeClass {
    def someProperty
    public someField
    private somePrivateField
}

def obj = new SomeClass()

def store = []
obj.properties.each { property ->
    store += property.key
    store += property.value
}
assert store.contains('someProperty')
assert store.contains('someField') == false
assert store.contains('somePrivateField') == false
assert store.contains('class')
assert store.contains('metaClass') == false // 2.5.8에서는 metaClass가 properties에 속해 있지 않음

assert obj.properties.size() == 2