import { assert } from 'chai';

function payAmount(employee) {
    if (employee.isSeparated) {
        return { amount: 0, reasonCode: 'SEP' };
    }
    if (employee.isRetired) {
        return { amount: 0, reasonCode: 'RET' };
    }
    //급여 계산 로직
    return { amount: 100 };
}

describe('payAmount', function () {
    let employee;
    beforeEach(function () {
        employee = {
            isSeparated: false,
            isRetired: false,
        };
    });
    it('return 100', function () {
        assert.deepEqual(payAmount(employee), { amount: 100 });
    });
    it('separated', function () {
        employee.isSeparated = true;
        assert.deepEqual(payAmount(employee), { amount: 0, reasonCode: 'SEP' });
    });
    it('retired', function () {
        employee.isRetired = true;
        assert.deepEqual(payAmount(employee), { amount: 0, reasonCode: 'RET' });
    });
});
