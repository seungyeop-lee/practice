import * as assert from 'assert';

export class Book {
    constructor() {
        this._reservations = [];
    }

    addReservation(customer) {
        this.zz_addReservation(customer, false);
    }

    zz_addReservation(customer, isPriority) {
        assert.strictEqual(isPriority === true || isPriority === false, true);
        this._reservations.push(customer);
    }
}
