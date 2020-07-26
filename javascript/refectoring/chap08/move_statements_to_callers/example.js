import { assert } from 'chai';

function renderPerson(outStream, person) {
    outStream.write(`<p>${person.name}</p>\n`);
    renderPhoto(outStream, person.photo);
    emitPhotoData(outStream, person.photo);
    outStream.write(`<p>위치: ${person.photo.location}</p>\n`);

    function renderPhoto(aPhoto) {
        return `<p>${aPhoto.binary}</p>`;
    }
}

function listRecentPhotos(outStream, photos) {
    photos
        .filter((p) => p.date > recentDateCutoff())
        .forEach((p) => {
            outStream.write(`<div>\n`);
            emitPhotoData(outStream, p);
            outStream.write(`<p>위치: ${p.location}</p>\n`);
            outStream.write(`</div>\n`);
        });

    function recentDateCutoff() {
        return new Date(2019, 7, 27, 0, 0, 0);
    }
}

function emitPhotoData(outStream, photo) {
    outStream.write(`<p>제목: ${photo.title}</p>\n`);
    outStream.write(`<p>날짜: ${photo.date.toDateString()}</p>\n`);
}

class OutStream {
    constructor(initString) {
        this._string = initString;
    }

    write(aString) {
        this._string += aString;
    }

    toString() {
        return this._string;
    }
}

describe('move statements to callers1', function () {
    let photo;
    let person;
    beforeEach(function () {
        photo = {
            binary: 'test binary',
            title: 'test title',
            location: 'test location',
            date: new Date(2020, 7, 27, 0, 0, 0),
        };
        person = {
            name: 'lee',
            photo: photo,
        };
    });
    it('renderPerson', function () {
        let outStream = new OutStream('');
        renderPerson(outStream, person);
        assert.equal(
            outStream.toString(),
            `<p>lee</p>
<p>제목: test title</p>
<p>날짜: Thu Aug 27 2020</p>
<p>위치: test location</p>
`
        );
    });

    it('listRecentPhotos', function () {
        let outStream = new OutStream('');
        listRecentPhotos(outStream, [photo]);
        assert.equal(
            outStream.toString(),
            `<div>
<p>제목: test title</p>
<p>날짜: Thu Aug 27 2020</p>
<p>위치: test location</p>
</div>
`
        );
    });
});
