class Person1 {
    name: string | undefined    // 초기화를 하지 않으려면 undefined 자료형을 같이 명시
    age?: number
}

let jack1: Person1 = new Person1()
jack1.name = 'Jack'
jack1.age = 32
console.log(jack1) // Person1 { name: 'Jack', age: 32 }
