import {readFilePromise} from "./readFilePromise";

readFilePromise('./package.json')
    .then((content) => {
        console.log(content)
        return readFilePromise('./tsconfig.json')
    })
    .then((content) => {
        console.log(content)
        return readFilePromise('.')
    })
    .catch((err) => console.log('error:', err.message))
    .finally(() => console.log('프로그램 종료'));
