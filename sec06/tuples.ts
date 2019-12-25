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
