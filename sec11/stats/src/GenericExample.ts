// NOTHING TO DO WITH GENERICS
const add = (a: number, b: number): number => {
  return a + b;
};
add(10, 1);
add(10, 2);
add(10, 3);

// Without GENERICS
// class HoldNumber {
//   data: number | undefined;
// }

// class HoldString {
//   data: string | undefined;
// }

// const holdNumber = new HoldNumber();
// holdNumber.data = 123;

// const holdString = new HoldString();
// holdString.data = 'sdlfkjsd';

// With GENERICS
class HoldAnything<TypeOfData> {
  data: TypeOfData | undefined;
}

const holdNumber = new HoldAnything<number>();
holdNumber.data = 123;

const holdString = new HoldAnything<string>();
holdString.data = 'sdlfkjsd';
