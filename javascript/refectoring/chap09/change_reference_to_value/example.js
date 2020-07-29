import { assert } from 'chai';

class Person {
    constructor() {
        this._telephoneNumber = new TelephoneNumber();
    }
    get officeAreaCode() {
        return this._telephoneNumber.areaCode;
    }
    set officeAreaCode(arg) {
        this._telephoneNumber.areaCode = arg;
    }
    get officeNumber() {
        return this._telephoneNumber.number;
    }
    set officeNumber(arg) {
        this._telephoneNumber.number = arg;
    }
}

class TelephoneNumber {
    get areaCode() {
        return this._areaCode;
    }
    set areaCode(arg) {
        this._areaCode = arg;
    }
    get number() {
        return this._number;
    }
    set number(arg) {
        this._number = arg;
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
});
