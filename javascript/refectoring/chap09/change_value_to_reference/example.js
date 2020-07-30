import { assert } from 'chai';

let _repositoryData;

export function initialize() {
    _repositoryData = {};
    _repositoryData.customers = new Map();
}
export function registerCustomer(id) {
    if (!_repositoryData.customers.has(id))
        _repositoryData.customers.set(id, new Customer(id));
    return findCustomer(id);
}
export function findCustomer(id) {
    return _repositoryData.customers.get(id);
}

class Order {
    constructor(data) {
        this._number = data.number;
        this._customer = registerCustomer(data.customer);
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
        initialize();
        orders.push(new Order({ customer: 'first', number: 10 }));
        orders.push(new Order({ customer: 'second', number: 20 }));
        orders.push(new Order({ customer: 'third', number: 30 }));
        orders.push(new Order({ customer: 'second', number: 40 }));
        orders.push(new Order({ customer: 'third', number: 50 }));
    });
    it('', function () {
        assert.equal(orders[0].customer.id, 'first');
        assert.equal(orders[1].customer.id, 'second');
        assert.equal(orders[2].customer.id, 'third');
        assert.equal(orders[3].customer.id, 'second');
        assert.equal(orders[4].customer.id, 'third');
    });
});
