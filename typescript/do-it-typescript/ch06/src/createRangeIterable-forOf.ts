import {createRangeIterable} from "./createRangeIterable";

const iterable = createRangeIterable(1, 3 + 1)
// for (let value of iterable) // error: does not have a '[Symbol.iterator]()' method
//     console.log(value)
