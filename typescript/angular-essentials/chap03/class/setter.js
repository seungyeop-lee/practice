class Foo {
    constructor(arr = []) {
        this._arr = arr;
    }

    get firstElem() {
        return this._arr.length ? this._arr[0]: null;
    }

    set firstElem(elem) {
        this._arr = [elem, ...this._arr];
    }
}

const foo = new Foo([1, 2]);

console.log(foo.firstElem)  // 1
foo.firstElem = 100;
console.log(foo.firstElem)  // 100
