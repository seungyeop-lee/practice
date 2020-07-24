import { assert } from 'chai';

class Shipment {
    get trackingInfo() {
        return `${this.shippingCompany}: ${this.trackingNumber}`;
    }

    // 배송 회사
    get shippingCompany() {
        return this._shippingCompany;
    }
    set shippingCompany(arg) {
        this._shippingCompany = arg;
    }

    // 추적 번호
    get trackingNumber() {
        return this._trackingNumber;
    }
    set trackingNumber(arg) {
        this._trackingNumber = arg;
    }
}

describe('Shipment', function () {
    let aShipment;
    beforeEach(function () {
        aShipment = new Shipment();
        aShipment.shippingCompany = 'test company';
        aShipment.trackingNumber = '12345-abcde-00000';
    });
    it('normal', function () {
        assert.equal(aShipment.trackingInfo, 'test company: 12345-abcde-00000');
    });
    it('change shippingCompany', function () {
        let request = { vendor: 'test vendor' };
        aShipment.shippingCompany = request.vendor;
        assert.equal(aShipment.trackingInfo, 'test vendor: 12345-abcde-00000');
    });
});
