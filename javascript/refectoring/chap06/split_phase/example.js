import { expect } from 'chai';

function priceOrder(product, quantity, shippingMethod) {
    const basePrice = product.basePrice * quantity;
    const discount =
        Math.max(quantity - product.discountThreshold, 0) *
        product.basePrice *
        product.discountRate;
    const shippingPerCase =
        basePrice > shippingMethod.discountThreshold
            ? shippingMethod.discountFee
            : shippingMethod.feePerCase;
    const shippingCost = quantity * shippingPerCase;
    const price = basePrice - discount + shippingCost;
    return price;
}

describe('', function () {
    it('priceOrder', function () {
        let product = {
            basePrice: 300,
            discountRate: 0.1,
            discountThreshold: 0.2,
        };
        let quantity = 200;
        let shippingMethod = {
            discountFee: 1000,
            feePerCase: 100,
        };
        expect(priceOrder(product, quantity, shippingMethod)).equal(74006);
    });
});
