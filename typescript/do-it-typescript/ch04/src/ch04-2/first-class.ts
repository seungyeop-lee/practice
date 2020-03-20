// @ts-ignore
let f = function (a, b) {
    return a + b
}
f = function (a, b) {
    // @ts-ignore
    return a - b;
};
