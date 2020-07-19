import { assert } from 'chai';

const customerData = {
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
};

describe('', function () {
    it('', function () {
        function compareUsage(customerID, laterYear, month) {
            const later = customerData[customerID].usages[laterYear][month];
            const earlier =
                customerData[customerID].usages[laterYear - 1][month];
            return { laterAmount: later, charge: later - earlier };
        }

        let customerID = '1920';
        let year = '2016';
        let month = '2';
        customerData[customerID].usages[year][month] = 10;
        customerData[customerID].usages[year - 1][month] = 20;

        let usage = compareUsage(customerID, year, month);
        assert.deepEqual(usage, { laterAmount: 10, charge: -10 });
    });
});
