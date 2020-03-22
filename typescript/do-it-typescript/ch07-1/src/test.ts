import {readFileSync, readFile} from "fs";

// 동기 방식
console.log('read package.json using synchronous api...')
const buffer: Buffer = readFileSync('./package.json')
console.log(buffer.toString())

// 비동기 방식
// @ts-ignore
readFile('./package.json', (error: Error, buffer: Buffer) => {
    console.log('read package.json using asynchronous api...')
    console.log(buffer.toString())
})

// Promise와 async/await 구문을 사용한 예 (실제 출력은 되지 않음 ;;;)
const readFilePromise = (filename: string): Promise<string> =>
    // @ts-ignore
    new Promise<string>((resolve, reject) => {
        // @ts-ignore
        readFile(filename, (error: Error, buffer: Buffer) => {
            if (error)
                reject(error)
            else
                resolve(buffer.toString())
        })
    })

(async () => {
    const content = await readFilePromise('./package.json')
    console.log('read package.json using Promise and async/await...')
    console.log(content)
})()
