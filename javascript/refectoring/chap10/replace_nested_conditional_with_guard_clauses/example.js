import { assert } from 'chai';

function payAmount(employee) {
    let result;
    if (employee.isSeparated) {
        // 퇴사한 직원인가?
        result = { amount: 0, reasonCode: 'SEP' };
    } else {
        if (employee.isRetired) {
            // 은퇴한 직원인가?
            result = { amount: 0, reasonCode: 'RET' };
        } else {
            //급여 계산 로직
            result = { amount: 100 };
        }
    }
    return result;
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
