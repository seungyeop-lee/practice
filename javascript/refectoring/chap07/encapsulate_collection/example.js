import { assert } from 'chai';
import { Person } from './person';
import { Course } from './course';

function readBasicCourseNames() {
    return ['a course', 'b course', 'c course'];
}

describe('', function () {
    let aPerson;
    beforeEach(function () {
        aPerson = new Person('lee');
    });

    it('', function () {
        const numAdvancedCourses = aPerson.courses.filter((c) => c.isAdvanced)
            .length;

        for (const name of readBasicCourseNames()) {
            aPerson.courses.push(new Course(name, false));
        }

        assert.equal(aPerson.courses.length, 3);
        assert.equal(aPerson.courses[0].name, 'a course');
        assert.equal(aPerson.courses[1].name, 'b course');
        assert.equal(aPerson.courses[2].name, 'c course');
    });
});
