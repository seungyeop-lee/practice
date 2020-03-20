// 해당 파일에 `export`가 붙어있는 모든 요소를 불러온다.
import {makeRandomNumber} from "../utils/makeRandomNumber";
import IPerson from './IPerson';

export default class Person implements IPerson {
    constructor(public name: string, public age: number = makeRandomNumber()) {
    }
}

// 외부 파일에서 사용하기 위해 `export` 키워드를 붙인다.
export const makePerson = (
    name: string,
    age: number = makeRandomNumber()
) => ({
    name,
    age
});
