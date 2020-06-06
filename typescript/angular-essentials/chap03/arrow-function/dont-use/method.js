const person = {
    name: 'Lee',
    sayHi: () => console.log(`Hi ${this.name}`)
};

person.sayHi(); // Hi undefined

const person2 = {
    name: 'Lee',
    sayHi() {
        console.log(`Hi ${this.name}`)
    }
};

person2.sayHi(); //  Hi Lee
