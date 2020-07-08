import {Province, sampleProvinceData} from "./province.js";
import {expect} from "chai";

describe('province', function () {
    it('shortfall', function () {
        const asia = new Province(sampleProvinceData());
        expect(asia.shortfall).equal(5);
    });
})
