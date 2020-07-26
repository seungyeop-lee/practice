import { assert } from 'chai';

class Account {
    constructor(number, type, interestRate) {
        this._number = number;
        this._type = type;
        this._interestRate = interestRate;
    }
    get interestRate() {
        return this._interestRate;
    }
}

class AccountType {
    constructor(nameString) {
        this._name = nameString;
    }
}

describe('', function () {
    let account;
    beforeEach(function () {
        account = new Account(0, new AccountType('normal'), 0.1);
    });
    it('', function () {
        assert.equal(account.interestRate, 0.1);
    });
});
