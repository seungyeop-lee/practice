import { price } from './example';
import { expect } from 'chai';

describe('price', function() {
    let order;
    beforeEach(function() {
        order = {
            quantity: 10,
            itemPrice: 100,
        };
    });
    it('normal', function() {
        expect(price(order)).equal(1100);
    });
});
