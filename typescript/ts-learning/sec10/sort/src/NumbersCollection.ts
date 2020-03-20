import { Sorter } from './Sorter';

export class NumbersCollection extends Sorter {
  constructor(public data: number[]) {
    super();
  }

  // get 키워드를 사용하면 length를 필드값으로 가져갈 경우 해당 메소드의 return값이 반환된다.
  get length(): number {
    return this.data.length;
  }

  compare(leftIndex: number, rightIndex: number): boolean {
    return this.data[leftIndex] > this.data[rightIndex];
  }

  swap(leftIndex: number, rightIndex: number): void {
    const leftHand = this.data[leftIndex];
    this.data[leftIndex] = this.data[rightIndex];
    this.data[rightIndex] = leftHand;
  }
}
