class Person2 {
    constructor(public name: string, public age?: number) {
    }
}

let jack2: Person2 = new Person2('Jack', 32)
console.log(jack2) // Person2 { name: 'Jack', age: 32 }


// 위의 생성자 축약을 장황하게 구현한 코드 (동일한 동작)
class Person3 {
    name: string
    age?: number
    constructor(name: string, age?: number) {
        this.name = name
        this.age = age
    }
}
let jack3: Person3 = new Person3('Jack', 32)
console.log(jack3) // Person3 { name: 'Jack', age: 32 }
