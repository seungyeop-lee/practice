// object
const drink = {
  color: 'brown',
  carbonated: true,
  sugar: 40
};

// array
const pepsi = ['brown', true, 40];
pepsi[0] = 40;
pepsi[2] = 'brown';

// Type alias (tuple)
type Drink = [string, boolean, number];

const coke: Drink = ['brown', true, 40];
const sprite: Drink = ['clear', true, 40];
const tea: Drink = ['brown', false, 0];

// 튜플은 각 데이터가 의미하는 바를 나타낼 수 없다.
const carSpece: [number, number] = [400, 3354];

// 객체는 각 데이터가 의미하는 바를 나타낼 수 있다.
const carStats = {
  horsepower: 400,
  weight: 3354
};
