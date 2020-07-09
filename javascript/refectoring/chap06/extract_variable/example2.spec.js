import { Order } from './example2';
import { expect } from 'chai';

describe('Order', function() {
    let aRecode;
    let order;
    beforeEach(function() {
        aRecode = {
            quantity: 10,
            itemPrice: 100,
        }
        order = new Order(aRecode)
    })
    it('price', function() {
        expect(order.price).equal(1100);
    });
})
