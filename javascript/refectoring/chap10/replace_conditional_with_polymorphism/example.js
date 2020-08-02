import { assert } from 'chai';

function plumages(birds) {
    return new Map(
        birds.map((b) => createBird(b)).map((bird) => [bird.name, bird.plumage])
    );
}

function speeds(birds) {
    return new Map(
        birds
            .map((b) => createBird(b))
            .map((bird) => [bird.name, bird.airSpeedVelocity])
    );
}

function createBird(bird) {
    switch (bird.type) {
        case '유럽 제비':
            return new EuropeanSwallow(bird);
        case '아프리카 제비':
            return new AfricanSwallow(bird);
        case '노르웨이 파랑 앵무':
            return new NorwegianBlueParrot(bird);
        default:
            return new Bird(bird);
    }
}

class Bird {
    constructor(birdObject) {
        Object.assign(this, birdObject);
    }

    get plumage() {
        return '알 수 없다';
    }

    get airSpeedVelocity() {
        return null;
    }
}
class EuropeanSwallow extends Bird {
    get plumage() {
        return '보통이다';
    }
    get airSpeedVelocity() {
        return 35;
    }
}
class AfricanSwallow extends Bird {
    get plumage() {
        return this.numberOfCoconuts > 2 ? '지쳤다' : '보통이다';
    }
    get airSpeedVelocity() {
        return 40 - 2 * this.numberOfCoconuts;
    }
}
class NorwegianBlueParrot extends Bird {
    get plumage() {
        return this.voltage > 100 ? '그을렸다' : '예쁘다';
    }
    get airSpeedVelocity() {
        return this.isNailed ? 0 : 10 + this.voltage / 10;
    }
}

describe('', function () {
    let birds;
    beforeEach(function () {
        birds = [
            {
                name: '유제',
                type: '유럽 제비',
            },
            {
                name: '아제',
                type: '아프리카 제비',
                numberOfCoconuts: 3,
            },
            {
                name: '파앵',
                type: '노르웨이 파랑 앵무',
                voltage: 101,
                isNailed: true,
            },
            {
                name: 'unknown',
                type: 'unknown',
            },
        ];
    });
    it('plumages', function () {
        let result = plumages(birds);
        assert.equal(result.get('유제'), '보통이다');
        assert.equal(result.get('아제'), '지쳤다');
        assert.equal(result.get('파앵'), '그을렸다');
        assert.equal(result.get('unknown'), '알 수 없다');
    });
    it('speeds', function () {
        let result = speeds(birds);
        assert.equal(result.get('유제'), 35);
        assert.equal(result.get('아제'), 34);
        assert.equal(result.get('파앵'), 0);
        assert.equal(result.get('unknown'), null);
    });
});
