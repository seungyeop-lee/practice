export class A {
    value: number = 1
    method: () => void = function(): void {
        // @ts-ignore
        console.log(`value: ${this.value}`)
    }
}
