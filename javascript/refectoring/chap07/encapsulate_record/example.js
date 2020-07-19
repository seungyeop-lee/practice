import { expect } from 'chai';

const organization = { name: '애크미 구스베리', country: 'GB' };

describe('', function () {
    it('', function () {
        let result = '';
        result += `<h1>${organization.name}</h1>`;
        result += `<h1>${organization.country}</h1>`;

        let newName = 'new name';
        let newCountry = 'new country';
        organization.name = newName;
        organization.country = newCountry;
        let newResult = '';
        newResult += `<h1>${organization.name}</h1>`;
        newResult += `<h1>${organization.country}</h1>`;

        expect(result).equal('<h1>애크미 구스베리</h1><h1>GB</h1>');
        expect(newResult).equal('<h1>new name</h1><h1>new country</h1>');
    });
});
