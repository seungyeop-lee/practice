import { assert } from 'chai';

function calculate(people) {
    return `최연소: ${youngestAge()}, 총 급여: ${totalSalary()}`;

    function totalSalary() {
        return people.reduce((total, p) => total + p.salary, 0);
    }

    function youngestAge() {
        return Math.min(...people.map((p) => p.age));
    }
}

describe('calculate', function () {
    let people;
    beforeEach(function () {
        people = [
            {
                name: 'lee',
                age: 34,
                salary: 200,
            },
            {
                name: 'kim',
                age: 28,
                salary: 300,
            },
            {
                name: 'park',
                age: 26,
                salary: 100,
            },
        ];
    });
    it('normal', function () {
        assert.equal(calculate(people), '최연소: 26, 총 급여: 600');
    });
});
