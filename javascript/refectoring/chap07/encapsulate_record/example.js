import { expect } from 'chai';

class Organization {
    constructor(data) {
        this._data = data;
    }

    set name(aString) {
        this._data.name = aString;
    }
    get name() {
        return this._data.name;
    }
    set country(aCountryCode) {
        this._data.country = aCountryCode;
    }
    get country() {
        return this._data.country;
    }
}

const organization = new Organization({
    name: '애크미 구스베리',
    country: 'GB',
});

function getOrganization() {
    return organization;
}

describe('', function () {
    it('', function () {
        let result = '';
        result += `<h1>${getOrganization().name}</h1>`;
        result += `<h1>${getOrganization().country}</h1>`;

        let newName = 'new name';
        let newCountry = 'new country';
        getOrganization().name = newName;
        getOrganization().country = newCountry;
        let newResult = '';
        newResult += `<h1>${getOrganization().name}</h1>`;
        newResult += `<h1>${getOrganization().country}</h1>`;

        expect(result).equal('<h1>애크미 구스베리</h1><h1>GB</h1>');
        expect(newResult).equal('<h1>new name</h1><h1>new country</h1>');
    });
});
