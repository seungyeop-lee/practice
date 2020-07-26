import { assert } from 'chai';

function renderPerson(outStream, person) {
    const result = [];
    result.push(`<p>${person.name}</p>`);
    result.push(renderPhoto(person.photo));
    result.push(emitPhotoData(person.photo));
    return result.join('\n');
}

function renderPhoto(aPhoto) {
    return `<p>${aPhoto.binary}</p>`;
}

function photoDiv(p) {
    return ['<div>', emitPhotoData(p), '</div>'].join('\n');
}

function emitPhotoData(p) {
    return [
        `<p>제목: ${p.title}</p>`,
        `<p>위치: ${p.location}</p>`,
        `<p>날짜: ${p.date.toDateString()}</p>`,
    ].join('\n');
}

describe('', function () {
    let person;
    let photo;
    beforeEach(function () {
        photo = {
            binary: 'test binary',
            title: 'test title',
            location: 'test location',
            date: new Date(2020, 7, 26, 0, 0, 0),
        };
        person = {
            name: 'lee',
            photo: photo,
        };
    });
    it('', function () {
        assert.equal(
            renderPerson({}, person),
            `<p>lee</p>
<p>test binary</p>
<p>제목: test title</p>
<p>위치: test location</p>
<p>날짜: Wed Aug 26 2020</p>`
        );
        assert.equal(
            photoDiv(photo),
            `<div>
<p>제목: test title</p>
<p>위치: test location</p>
<p>날짜: Wed Aug 26 2020</p>
</div>`
        );
    });
});
