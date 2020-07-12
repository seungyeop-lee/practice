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

function client1() {
    const aReading = acquireReading();
    const baseCharge =
        baseRate(aReading.month, aReading.year) * aReading.quantity;
    return baseCharge;
}

function client2() {
    const aReading = acquireReading();
    const base = baseRate(aReading.month, aReading.year) * aReading.quantity;
    const taxableCharge = Math.max(0, base - taxThreshold(aReading.year));
    return taxableCharge;
}

function client3() {
    const aReading = acquireReading();
    const basicChargeAmount = calculateBaseCharge(aReading);
    return basicChargeAmount;

    function calculateBaseCharge(aReading) {
        return baseRate(aReading.month, aReading.year) * aReading.quantity;
    }
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
