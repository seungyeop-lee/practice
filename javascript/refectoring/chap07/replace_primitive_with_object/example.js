import { assert } from 'chai';

export class Order {
    constructor(data) {
        this.priority = data.priority;
    }
}

describe('', function () {
    let orders;
    beforeEach(function () {
        orders = [
            new Order({ priority: 'high' }),
            new Order({ priority: 'rush' }),
            new Order({ priority: 'low' }),
        ];
    });
    it('', function () {
        const highPriorityCount = orders.filter(
            (o) => 'high' === o.priority || 'rush' === o.priority
        ).length;

        assert.equal(highPriorityCount, 2);
    });
});
