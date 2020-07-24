import { assert } from 'chai';

class Person {
    set department(arg) {
        this._department = arg;
    }
    get manager() {
        return this._department.manager;
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
        let manager = aPerson.manager;
        assert.equal(manager, 'test manager');
    });
});
