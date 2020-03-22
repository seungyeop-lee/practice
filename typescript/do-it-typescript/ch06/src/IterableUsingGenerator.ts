export class IterableUsingGenerator<T> implements Iterable<T> {
    constructor(private values: T[] = [], private currentIndex: number = 0) {
    }

    *generator () {
        while (this.currentIndex < this.values.length)
        yield this.values[this.currentIndex++]
    }
    [Symbol.iterator] = this.generator
}
