import {readFile} from 'fs'

export const readFilePromise = (filename: string): Promise<string> =>
    new Promise<string>(
        (resolve, reject) => {
            console.log('execute Promise')
            readFile(filename, (err, buffer) => {
                if(err) reject(err)
                else resolve(buffer.toString())
            })
        }
    )
