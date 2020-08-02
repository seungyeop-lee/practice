import { assert } from 'chai';

function disabilityAmount(anEmployee) {
    if (isNotEligibleForDisability()) return 0;
    return 100;

    function isNotEligibleForDisability() {
        return (
            anEmployee.seniority < 2 ||
            anEmployee.monthsDisabled > 12 ||
            anEmployee.isPartTime
        );
    }
}

describe('disabilityAmount', function () {
    let employee;
    beforeEach(function () {
        employee = {
            seniority: 2,
            monthsDisabled: 12,
            isPartTime: false,
        };
    });
    it('return 100', function () {
        assert.equal(disabilityAmount(employee), 100);
    });
    it('seniority is low', function () {
        employee.seniority = 1;
        assert.equal(disabilityAmount(employee), 0);
    });
    it('monthsDisabled is high', function () {
        employee.monthsDisabled = 13;
        assert.equal(disabilityAmount(employee), 0);
    });
    it('partTime', function () {
        employee.isPartTime = true;
        assert.equal(disabilityAmount(employee), 0);
    });
});
