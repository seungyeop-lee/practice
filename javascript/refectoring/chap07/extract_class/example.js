import { assert } from 'chai';

class Person {
    get name() {
        return this._name;
    }
    set name(arg) {
        this._name = arg;
    }
    get telephoneNumber() {
        return `(${this.officeAreaCode}) ${this.officeNumber}`;
    }
    get officeAreaCode() {
        return this._officeAreaCode;
    }
    set officeAreaCode(arg) {
        this._officeAreaCode = arg;
    }
    get officeNumber() {
        return this._officeNumber;
    }
    set officeNumber(arg) {
        this._officeNumber = arg;
    }
}

describe('', function () {
    beforeEach(function () {});
    it('', function () {
        let person = new Person();
        person.name = 'lsy';
        person.officeAreaCode = '032';
        person.officeNumber = '0123-4567';
        assert.equal(person.telephoneNumber, '(032) 0123-4567');
    });
});
