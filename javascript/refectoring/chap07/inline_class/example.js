import { assert } from 'chai';

class TrackingInformation {
    get display() {
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

class Shipment {
    get trackingInfo() {
        return this._trackingInformation.display;
    }
    get trackingInformation() {
        return this._trackingInformation;
    }
    set trackingInformation(aTrackingInformation) {
        this._trackingInformation = aTrackingInformation;
    }
}

describe('Shipment', function () {
    let aShipment;
    beforeEach(function () {
        let trackingInfo = new TrackingInformation();
        trackingInfo.shippingCompany = 'test company';
        trackingInfo.trackingNumber = '12345-abcde-00000';
        aShipment = new Shipment();
        aShipment.trackingInformation = trackingInfo;
    });
    it('normal', function () {
        assert.equal(aShipment.trackingInfo, 'test company: 12345-abcde-00000');
    });
    it('change shippingCompany', function () {
        let request = { vendor: 'test vendor' };
        aShipment.trackingInformation.shippingCompany = request.vendor;
        assert.equal(aShipment.trackingInfo, 'test vendor: 12345-abcde-00000');
    });
});
