import { assert } from 'chai';

class ProductionPlan {
    constructor() {
        this._production = 0;
        this._adjustments = [];
    }

    get production() {
        return this._adjustments.reduce((sum, a) => sum + a.amount, 0);
    }

    applyAdjustment(anAdjustment) {
        this._adjustments.push(anAdjustment);
    }
}

describe('ProductionPlan', function () {
    let productionPlan;
    beforeEach(function () {
        productionPlan = new ProductionPlan();
    });
    it('normal', function () {
        productionPlan.applyAdjustment({ amount: 100 });
        assert.equal(productionPlan.production, 100);
        productionPlan.applyAdjustment({ amount: 200 });
        assert.equal(productionPlan.production, 300);
    });
});
