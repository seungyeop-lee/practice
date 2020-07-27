import { assert } from 'chai';

function acquireData(input) {
    const lines = input.split('\n');
    return lines
        .slice(1)
        .filter((line) => line.trim() !== '')
        .map((line) => line.split(','))
        .filter((fields) => fields[1].trim() === 'India')
        .map((fields) => ({ city: fields[0].trim(), phone: fields[2].trim() }));
}

describe('acquireData', function () {
    let data;
    beforeEach(function () {
        data = `office, country, telephone
Chicago, USA, +1 312 373 1000
Beijing, China, +86 4008 900 505
Bangalore, India, +91 80 4064 9570
Porto Alegre, Brazil, +55 51 3079 3550
Chennai, India, +91 44 660 44766`;
    });
    it('normal', function () {
        assert.deepEqual(acquireData(data), [
            {
                city: 'Bangalore',
                phone: '+91 80 4064 9570',
            },
            {
                city: 'Chennai',
                phone: '+91 44 660 44766',
            },
        ]);
    });
});
