class Foo {
    constructor(arr = []) {
        this._arr = arr;
    }

    get firstElem() {
        return this._arr.length ? this._arr[0] : null;
    }
}

const foo = new Foo([1, 2]);
console.log(foo.firstElem)  // 1
