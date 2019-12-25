// return형은 추론이 가능하다.
const add = (a: number, b: number): number => {
  return a + b;
};

// but! 실수 방지를 위해 언제나 선언하도록 한다.
const subtract = (a: number, b: number): number => {
  return a - b;
};

function divide(a: number, b: number): number {
  return a / b;
}

const multiply = function(a: number, b: number): number {
  return a * b;
};
