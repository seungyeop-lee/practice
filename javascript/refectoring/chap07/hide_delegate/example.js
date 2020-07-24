import { assert } from 'chai';

class Person {
    constructor(name) {
        this._name = name;
    }
    get name() {
        return this._name;
    }
    get department() {
        return this._department;
    }
    set department(arg) {
        this._department = arg;
    }
}

class Department {
    get chargeCode() {
        return this._chargeCode;
    }
    set chargeCode(arg) {
        this._chargeCode = arg;
    }
    get manager() {
        return this._manager;
    }
    set manager(arg) {
        this._manager = arg;
    }
}

describe('', function () {
    let aPerson;
    beforeEach(function () {
        aPerson = new Person('Lee');
        let department = new Department();
        department.chargeCode = 'aaa1';
        department.manager = 'test manager';
        aPerson.department = department;
    });
    it('', function () {
        let manager = aPerson.department.manager;
        assert.equal(manager, 'test manager');
    });
});
