import { Book } from './example3';
import { expect } from 'chai';

describe('Book', function () {
    let book;
    beforeEach(function () {
        book = new Book();
    });
    it('addReservation', function () {
        book.addReservation('new customer');
        expect(book._reservations).contains('new customer');
    });
});
