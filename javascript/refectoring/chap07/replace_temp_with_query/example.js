import { assert } from 'chai';

class Order {
    constructor(quantity, item) {
        this._quantity = quantity;
        this._item = item;
    }

    get price() {
        return this.basePrice * this.discountFactor;
    }

    get discountFactor() {
        let discountFactor = 0.98;
        if (this.basePrice > 1000) discountFactor -= 0.03;
        return discountFactor;
    }

    get basePrice() {
        return this._quantity * this._item.price;
    }
}

describe('', function () {
    it('', function () {
        let order = new Order(10, { price: 100 });
        assert.equal(order.price, 980);
        order = new Order(10, { price: 200 });
        assert.equal(order.price, 1900);
    });
});
