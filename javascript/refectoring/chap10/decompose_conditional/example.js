import { assert } from 'chai';

class CustomDate {
    constructor(aDate) {
        this._date = aDate;
    }

    isBefore(other) {
        return this._date < other;
    }

    isAfter(other) {
        return this._date > other;
    }
}

function calculate(aDate, quantity, plan) {
    let charge;
    if (!aDate.isBefore(plan.summerStart) && !aDate.isAfter(plan.summerEnd))
        charge = quantity * plan.summerRate;
    else charge = quantity * plan.regularRate + plan.regularServiceCharge;
    return charge;
}

describe('calculate', function () {
    it('summer', function () {
        let date = new CustomDate(new Date(2020, 8, 2));
        let quantity = 10000;
        let plan = {
            summerStart: new Date(2020, 6, 17),
            summerEnd: new Date(2020, 8, 30),
            summerRate: 1.3,
            regularRate: 1.1,
            regularServiceCharge: 1000,
        };
        assert.equal(calculate(date, quantity, plan), 13000);
    });
    it('not summer', function () {
        let date = new CustomDate(new Date(2020, 10, 2));
        let quantity = 10000;
        let plan = {
            summerStart: new Date(2020, 6, 17),
            summerEnd: new Date(2020, 8, 30),
            summerRate: 1.3,
            regularRate: 1.1,
            regularServiceCharge: 1000,
        };
        assert.equal(calculate(date, quantity, plan), 12000);
    });
});
