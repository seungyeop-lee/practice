interface INameable {
    name: string
}

function getName(o: INameable | undefined) {
    return o != undefined ? o.name : 'unknown name'
}

let n = getName(undefined) // 현재는 undefined나 null을 파라미터에 명시하지 않으면 인자로 사용불가
console.log(n)
console.log(getName({name: 'Jack'}))
