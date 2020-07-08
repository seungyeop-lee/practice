import { printOwing } from './example';

describe('printOwing', function () {
    let invoice;
    beforeEach(function () {
        invoice = {
            customer: 'LEE',
            orders: [
                {
                    amount: 1000,
                },
                {
                    amount: 2000,
                },
                {
                    amount: 3000,
                },
            ],
        };
    });

    it('normal', function () {
        printOwing(invoice);
    });
});
