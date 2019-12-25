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

// void를 반환값으로 선언 할 경우, null과 undefined를 return하는 것이 가능하다.
const logger = (message: string): void => {
  console.log(message);
};

// never는 exception과 같이 throw되는 함수에 주로 사용된다.
const throwError = (message: string): never => {
  throw new Error(message);
};
