import { assert } from 'chai';

function renderPerson(outStream, person) {
    const result = [];
    result.push(`<p>${person.name}</p>`);
    result.push(renderPhoto(person.photo));
    result.push(`<p>제목: ${person.photo.title}</p>`);
    result.push(emitPhotoData(person.photo));
    return result.join('\n');
}

function renderPhoto(aPhoto) {
    return `<p>${aPhoto.binary}</p>`;
}

function photoDiv(p) {
    return [
        '<div>',
        `<p>제목: ${p.title}</p>`,
        emitPhotoData(p),
        '</div>',
    ].join('\n');
}

function emitPhotoData(aPhoto) {
    const result = [];
    result.push(`<p>위치: ${aPhoto.location}</p>`);
    result.push(`<p>날짜: ${aPhoto.date.toDateString()}</p>`);
    return result.join('\n');
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
