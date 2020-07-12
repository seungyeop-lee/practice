import { expect } from 'chai';

let reading = { customer: 'ivan', quantity: 10, month: 5, year: 2017 };

function acquireReading() {
    return reading;
}

function baseRate(month, year) {
    return month * year;
}

function taxThreshold(year) {
    return year;
}

class Reading {
    constructor(data) {
        this._customer = data.customer;
        this._quantity = data.quantity;
        this._month = data.month;
        this._year = data.year;
    }
    get customer() {
        return this._customer;
    }
    get quantity() {
        return this._quantity;
    }
    get month() {
        return this._month;
    }
    get year() {
        return this._year;
    }
    get baseCharge() {
        return baseRate(this.month, this.year) * this.quantity;
    }
    get taxableCharge() {
        return Math.max(0, this.baseCharge - taxThreshold(this.year));
    }
}

function client1() {
    const rawReading = acquireReading();
    const aReading = new Reading(rawReading);
    const baseCharge = aReading.baseCharge;
    return baseCharge;
}

function client2() {
    const rawReading = acquireReading();
    const aReading = new Reading(rawReading);
    const taxableCharge = aReading.taxableCharge;
    return taxableCharge;
}

function client3() {
    const rawReading = acquireReading();
    const aReading = new Reading(rawReading);
    const basicChargeAmount = aReading.baseCharge;
    return basicChargeAmount;
}

describe('', function () {
    it('client1', function () {
        expect(client1()).equal(100850);
    });
    it('client2', function () {
        expect(client2()).equal(98833);
    });
    it('client3', function () {
        expect(client3()).equal(100850);
    });
});
