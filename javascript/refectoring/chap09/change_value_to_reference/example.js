import { assert } from 'chai';

class Order {
    constructor(data) {
        this._number = data.number;
        this._customer = new Customer(data.customer);
        // 다른 데이터를 읽어 들인다.
    }

    get customer() {
        return this._customer;
    }
}

class Customer {
    constructor(id) {
        this._id = id;
    }

    get id() {
        return this._id;
    }
}

describe('', function () {
    let orders = [];
    beforeEach(function () {
        orders.push(new Order({ customer: 'first', number: 10 }));
        orders.push(new Order({ customer: 'second', number: 20 }));
        orders.push(new Order({ customer: 'third', number: 30 }));
    });
    it('', function () {
        assert.equal(orders[0].customer.id, 'first');
        assert.equal(orders[1].customer.id, 'second');
        assert.equal(orders[2].customer.id, 'third');
    });
});
