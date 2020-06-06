let foo = 123;
{
    let foo = 456;
    let bar = 456;
}
console.log(foo);   // 123
// console.log(bar);    // ReferenceError: bar is not defined
