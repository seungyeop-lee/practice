import { assert } from 'chai';

class Person {
    get department() {
        return this._department;
    }
    set department(arg) {
        this._department = arg;
    }
}

class Department {
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
        aPerson = new Person();
        let department = new Department();
        department.manager = 'test manager';
        aPerson.department = department;
    });
    it('', function () {
        let manager = aPerson.department.manager;
        assert.equal(manager, 'test manager');
    });
});
