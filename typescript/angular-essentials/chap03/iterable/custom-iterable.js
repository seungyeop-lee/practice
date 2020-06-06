const fibonacci = {
    [Symbol.iterator]() {
        let [prev, curr] = [0, 1];
        let step = 0;
        const maxStep = 10;
        return {
            next() {
                [prev, curr] = [curr, prev + curr];
                return {value: curr, done: step++ >= maxStep};
            }
        };
    }
}

for (const num of fibonacci) {
    console.log(num);
}

const arr = [...fibonacci];
console.log(arr);

const [first, second, ...rest] = fibonacci;
console.log(first, second, rest);
