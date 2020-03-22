Promise.resolve(1)
    .then(value => {
        console.log(value)
        return Promise.resolve(true)
    })
    .then(value => {
        console.log(value)
        return [1, 2, 3]
    })
    .then(value => {
        console.log(value)
        return {name: 'jack', age: 32}
    })
    .then(value => {
        console.log(value)
    })
