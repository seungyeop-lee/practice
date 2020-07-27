import { assert } from 'chai';

function calculate(people) {
    let youngest = people[0] ? people[0].age : Infinity;
    let totalSalary = 0;
    for (const p of people) {
        totalSalary += p.salary;
    }
    for (const p of people) {
        if (p.age < youngest) youngest = p.age;
    }
    return `최연소: ${youngest}, 총 급여: ${totalSalary}`;
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
