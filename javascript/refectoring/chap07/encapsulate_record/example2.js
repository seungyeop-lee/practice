import { assert } from 'chai';
import _ from 'lodash';

class CustomerData {
    constructor(data) {
        this._data = data;
    }
    get rawData() {
        return _.cloneDeep(this._data);
    }

    setUsage(customerID, year, month, amount) {
        this._data[customerID].usages[year][month] = amount;
    }
    usage(customerID, year, month) {
        return this._data[customerID].usages[year][month];
    }
}

let customerData = new CustomerData({
    '1920': {
        name: '마틴 파울러',
        id: '1920',
        usages: {
            '2016': {
                '1': 50,
                '2': 55,
                // 나머지 달(month)은 생략
            },
            '2015': {
                '1': 70,
                '2': 63,
                // 나머지 달은 생략
            },
        },
    },
    '38673': {
        name: '닐 포드',
        id: '38673',
        // 다른 고객 정보도 같은 형식으로 저장된다.
    },
});

function getCustomerData() {
    return customerData;
}

describe('', function () {
    it('', function () {
        function compareUsage(customerID, laterYear, month) {
            const later = getCustomerData().usage(customerID, laterYear, month);
            const earlier = getCustomerData().usage(
                customerID,
                laterYear - 1,
                month
            );
            return { laterAmount: later, charge: later - earlier };
        }

        let customerID = '1920';
        let year = '2016';
        let month = '2';
        getCustomerData().setUsage(customerID, year, month, 10);
        getCustomerData().setUsage(customerID, year - 1, month, 20);

        let usage = compareUsage(customerID, year, month);
        assert.deepEqual(usage, { laterAmount: 10, charge: -10 });
    });
});
