import { assert } from 'chai';

function calculate(anEmployee) {
    if (anEmployee.onVacation && anEmployee.seniority > 10) return 1;
    return 0.5;
}

describe('', function () {
    let employee;
    beforeEach(function () {
        employee = {
            onVacation: true,
            seniority: 11,
        };
    });
    it('return 1', function () {
        assert.equal(calculate(employee), 1);
    });
    it('not vacation', function () {
        employee.onVacation = false;
        assert.equal(calculate(employee), 0.5);
    });
    it('seniority is low', function () {
        employee.seniority = 10;
        assert.equal(calculate(employee), 0.5);
    });
});
