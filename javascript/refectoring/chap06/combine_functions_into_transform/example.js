import { assert, expect } from 'chai';
import _ from 'lodash';

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

function enrichReading(original) {
    const result = _.cloneDeep(original);
    result.baseCharge = calculateBaseCharge(result);
    result.taxableCharge = Math.max(
        0,
        result.baseCharge - taxThreshold(result.year)
    );
    return result;

    function calculateBaseCharge(aReading) {
        return baseRate(aReading.month, aReading.year) * aReading.quantity;
    }
}

function client1() {
    const rawReading = acquireReading();
    const aReading = enrichReading(rawReading);
    const baseCharge = aReading.baseCharge;
    return baseCharge;
}

function client2() {
    const rawReading = acquireReading();
    const aReading = enrichReading(rawReading);
    const taxableCharge = aReading.taxableCharge;
    return taxableCharge;
}

function client3() {
    const rawReading = acquireReading();
    const aReading = enrichReading(rawReading);
    const basicChargeAmount = aReading.baseCharge;
    return basicChargeAmount;
}

describe('combine_functions_into_transform', function () {
    it('client1', function () {
        expect(client1()).equal(100850);
    });
    it('client2', function () {
        expect(client2()).equal(98833);
    });
    it('client3', function () {
        expect(client3()).equal(100850);
    });
    it('check reading unchanged', function () {
        const baseReading = {
            customer: 'ivan',
            quantity: 15,
            month: 5,
            year: 2017,
        };
        const oracle = _.cloneDeep(baseReading);
        enrichReading(baseReading);
        assert.deepEqual(baseReading, oracle);
    });
});
