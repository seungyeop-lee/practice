import { assert } from 'chai';

class Priority {
    constructor(value) {
        this._value = value;
    }
    toString() {
        return this._value;
    }
}

class Order {
    constructor(data) {
        this._priority = data.priority;
    }

    get priorityString() {
        return this._priority.toString();
    }

    set priority(aString) {
        this._priority = new Priority(aString);
    }
}

describe('', function () {
    let orders;
    beforeEach(function () {
        orders = [
            new Order({ priority: new Priority('high') }),
            new Order({ priority: new Priority('rush') }),
            new Order({ priority: new Priority('low') }),
        ];
    });
    it('', function () {
        const highPriorityCount = orders.filter(
            (o) => 'high' === o.priorityString || 'rush' === o.priorityString
        ).length;

        assert.equal(highPriorityCount, 2);
    });
});
