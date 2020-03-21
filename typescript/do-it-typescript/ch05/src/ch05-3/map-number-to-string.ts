import {range} from "../ch05-1/range";

let names: string[] = range(1, 5 + 1)
    .map((val: number, index) => `[${index}]: ${val}`)
console.log(names)
