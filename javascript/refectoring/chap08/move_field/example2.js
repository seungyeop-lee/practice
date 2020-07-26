import { assert } from 'chai';

class Account {
    constructor(number, type) {
        this._number = number;
        this._type = type;
    }
    get interestRate() {
        return this._type.interestRate;
    }
}

class AccountType {
    constructor(nameString, interestRate) {
        this._name = nameString;
        this._interestRate = interestRate;
    }
    get interestRate() {
        return this._interestRate;
    }
}

describe('', function () {
    let account;
    beforeEach(function () {
        account = new Account(0, new AccountType('normal', 0.1));
    });
    it('', function () {
        assert.equal(account.interestRate, 0.1);
    });
});
