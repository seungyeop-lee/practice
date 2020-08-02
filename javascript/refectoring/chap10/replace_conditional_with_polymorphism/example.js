import { assert } from 'chai';

function plumages(birds) {
    return new Map(birds.map((b) => [b.name, plumage(b)]));
}

function speeds(birds) {
    return new Map(birds.map((b) => [b.name, airSpeedVelocity(b)]));
}

function plumage(bird) {
    // 깃털 상태
    switch (bird.type) {
        case '유럽 제비':
            return '보통이다';
        case '아프리카 제비':
            return bird.numberOfCoconuts > 2 ? '지쳤다' : '보통이다';
        case '노르웨이 파랑 앵무':
            return bird.voltage > 100 ? '그을렸다' : '예쁘다';
        default:
            return '알 수 없다';
    }
}
function airSpeedVelocity(bird) {
    // 비행 속도
    switch (bird.type) {
        case '유럽 제비':
            return 35;
        case '아프리카 제비':
            return 40 - 2 * bird.numberOfCoconuts;
        case '노르웨이 파랑 앵무':
            return bird.isNailed ? 0 : 10 + bird.voltage / 10;
        default:
            return null;
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
