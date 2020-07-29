import { assert } from 'chai';

class ProductionPlan {
    constructor(production) {
        this._production = production;
        this._adjustments = [];
    }

    get production() {
        return this._production;
    }

    applyAdjustment(anAdjustment) {
        this._adjustments.push(anAdjustment);
        this._production += anAdjustment.amount;
    }
}

describe('ProductionPlan', function () {
    let productionPlan;
    it('init production is 0', function () {
        productionPlan = new ProductionPlan(0);
        productionPlan.applyAdjustment({ amount: 100 });
        assert.equal(productionPlan.production, 100);
        productionPlan.applyAdjustment({ amount: 200 });
        assert.equal(productionPlan.production, 300);
    });

    it('init production is 100', function () {
        productionPlan = new ProductionPlan(100);
        productionPlan.applyAdjustment({ amount: 100 });
        assert.equal(productionPlan.production, 200);
        productionPlan.applyAdjustment({ amount: 200 });
        assert.equal(productionPlan.production, 400);
    });
});
