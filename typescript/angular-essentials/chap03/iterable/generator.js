function* foo(n) {
    console.log('n:' + n)   // 1
    const x = yield n;

    console.log('x:' + x)   // 10
    const y = yield (x + 1);

    console.log('y:' + y)   // 20
    const z = yield (y + 2);

    console.log('z:' + z)   // 30
    return x + y + z;
}

const iterator = foo(1);
console.log(iterator.next());   // { value: 1, done: false }
console.log(iterator.next(10)); // { value: 11, done: false }
console.log(iterator.next(20)); // { value: 22, done: false }
console.log(iterator.next(30)); // { value: 60, done: true }
