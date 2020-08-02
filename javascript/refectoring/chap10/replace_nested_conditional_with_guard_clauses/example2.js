import { assert } from 'chai';

function adjustedCapital(anInstrument) {
    let result = 0;
    if (anInstrument.capital > 0) {
        if (anInstrument.interestRate > 0 && anInstrument.duration > 0) {
            result =
                (anInstrument.income / anInstrument.duration) *
                anInstrument.adjustmentFactor;
        }
    }
    return result;
}

describe('adjustedCapital', function () {
    let instrument;
    beforeEach(function () {
        instrument = {
            capital: 1,
            interestRate: 0.1,
            duration: 0.2,
            income: 0.3,
            adjustmentFactor: 0.4,
        };
    });
    it('normar', function () {
        assert.equal(adjustedCapital(instrument), 0.6);
    });
    it('capital is negative', function () {
        instrument.capital = -1;
        assert.equal(adjustedCapital(instrument), 0);
    });
    it('interestRate is negative', function () {
        instrument.interestRate = -1;
        assert.equal(adjustedCapital(instrument), 0);
    });
    it('duration is negative', function () {
        instrument.duration = -1;
        assert.equal(adjustedCapital(instrument), 0);
    });
});
