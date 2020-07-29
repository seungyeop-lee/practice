import { assert } from 'chai';

class ProductionPlan {
    constructor(production) {
        this._initialProduction = production;
        this._adjustments = [];
    }

    get production() {
        return this._initialProduction + this.calculateProductionAccumulator;
    }

    get calculateProductionAccumulator() {
        return this._adjustments.reduce((sum, a) => sum + a.amount, 0);
    }

    applyAdjustment(anAdjustment) {
        this._adjustments.push(anAdjustment);
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
