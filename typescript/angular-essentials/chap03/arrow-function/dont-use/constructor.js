const Foo = () => {};

console.log(Foo.hasOwnProperty('prototype'));   // false

// const foo = new Foo();  // TypeError: Foo is not a constructor
