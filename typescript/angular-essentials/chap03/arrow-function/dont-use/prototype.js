const person = {
    name: 'Lee'
}
Object.prototype.sayHi = () => console.log(`Hi ${this.name}`);

person.sayHi(); // Hi undefined

const person2 = {
    name: 'Lee'
}
Object.prototype.sayHi = function () {
    console.log(`Hi ${this.name}`);
};
person2.sayHi(); // Hi Lee
