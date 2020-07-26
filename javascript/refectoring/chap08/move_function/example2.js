import { assert } from 'chai';

class Account {
    constructor(aAccountType, daysOverdrawn) {
        this._type = aAccountType;
        this._daysOverdrawn = daysOverdrawn;
    }

    // 은행 이자 계산
    get bankCharge() {
        let result = 4.5;
        if (this._daysOverdrawn > 0) {
            result += this.overdraftCharge;
        }
        return result;
    }

    get overdraftCharge() {
        return this.type.overdraftCharge(this);
    }

    get daysOverdrawn() {
        return this._daysOverdrawn;
    }

    get type() {
        return this._type;
    }
}

class AccountType {
    constructor(isPremium) {
        this._isPremium = isPremium;
    }

    get isPremium() {
        return this._isPremium;
    }

    // 초과 인출 이자 계산
    overdraftCharge(account) {
        if (this.isPremium) {
            const baseCharge = 10;
            if (account.daysOverdrawn <= 7) {
                return baseCharge;
            } else {
                return baseCharge + (account.daysOverdrawn - 7) * 0.85;
            }
        } else {
            return account.daysOverdrawn * 1.75;
        }
    }
}

describe('', function () {
    let account1;
    let account2;
    beforeEach(function () {
        account1 = new Account(new AccountType(true), 7);
        account2 = new Account(new AccountType(false), 8);
    });
    it('', function () {
        assert.equal(account1.bankCharge, 14.5);
        assert.equal(account2.bankCharge, 18.5);
    });
});
