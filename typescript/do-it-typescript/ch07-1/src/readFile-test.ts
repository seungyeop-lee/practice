import {readFile} from "fs";

readFile('./package.json', (err, data) => {
    if(err) throw err
    else {
        const content: string = data.toString()
        console.log(content)
    }
})
