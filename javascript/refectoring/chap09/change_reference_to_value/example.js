import { assert } from 'chai';

class Person {
    constructor() {
        this._telephoneNumber = new TelephoneNumber();
    }
    get officeAreaCode() {
        return this._telephoneNumber.areaCode;
    }
    set officeAreaCode(arg) {
        this._telephoneNumber = new TelephoneNumber(arg, this.officeNumber);
    }
    get officeNumber() {
        return this._telephoneNumber.number;
    }
    set officeNumber(arg) {
        this._telephoneNumber = new TelephoneNumber(this.officeAreaCode, arg);
    }
}

class TelephoneNumber {
    constructor(areaCode, number) {
        this._areaCode = areaCode;
        this._number = number;
    }
    get areaCode() {
        return this._areaCode;
    }
    get number() {
        return this._number;
    }

    equals(other) {
        if (!(other instanceof TelephoneNumber)) return false;
        return this.areaCode === other.areaCode && this.number === other.number;
    }
}

describe('Person', function () {
    let person;
    beforeEach(function () {
        person = new Person();
    });
    it('', function () {
        person.officeAreaCode = '02';
        person.officeNumber = '1234-5678';
        assert.equal(person.officeAreaCode, '02');
        assert.equal(person.officeNumber, '1234-5678');
    });
    it('telephone equals', function () {
        assert.isTrue(
            new TelephoneNumber('02', '1234-5678').equals(
                new TelephoneNumber('02', '1234-5678')
            )
        );
    });
});
