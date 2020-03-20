interface IPerson {
    name: string
    age: number
}
let good: IPerson = {name: 'Jack', age: 32}

// let bad1: IPerson = {name: 'Jack'}  // age 속성이 없어 오류
// let bad2: IPerson = {age: 32} // name 속성이 없어 오류
// let bad3: IPerson = {} // name과 age 속성이 없어 오류
// let bad4: IPerson = {name: 'Jack', age: 32, etc: true} // ect 속성이 있어 오류
