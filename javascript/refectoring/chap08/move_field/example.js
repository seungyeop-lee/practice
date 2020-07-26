import { assert } from 'chai';

let dateToday = function () {
    return new Date();
};

class Customer {
    constructor(name, discountRate) {
        this._name = name;
        this._contract = new CustomerContract(dateToday(), discountRate);
    }
    get discountRate() {
        return this._contract.discountRate;
    }
    _setDiscountRate(aNumber) {
        this._contract.discountRate = aNumber;
    }

    becomePreferred() {
        this._setDiscountRate(this.discountRate + 0.03);
        // 다른 멋진 일들
    }

    applyDiscount(amount) {
        return amount.subtract(amount.multiply(this.discountRate));
    }
}

class CustomerContract {
    constructor(startDate, discountRate) {
        this._startDate = startDate;
        this._discountRate = discountRate;
    }

    get discountRate() {
        return this._discountRate;
    }
    set discountRate(arg) {
        this._discountRate = arg;
    }
}

class Amount {
    constructor(aNumber) {
        this._amount = aNumber;
    }

    subtract(aNumber) {
        return this._amount - aNumber;
    }

    multiply(aNumber) {
        return this._amount * aNumber;
    }
}

describe('', function () {
    let customer;
    beforeEach(function () {
        customer = new Customer('Lee', 0.1);
    });
    it('', function () {
        assert.equal(customer.discountRate, 0.1);
        assert.equal(customer.applyDiscount(new Amount(100)), 90);
        customer.becomePreferred();
        assert.equal(customer.applyDiscount(new Amount(100)), 87);
    });
});
