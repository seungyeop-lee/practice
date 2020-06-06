function Prefixer(prefix) {
    this.prefix = prefix;
}

Prefixer.prototype.prefixArray = function (arr) {
    return arr.map(function (x) {
        return this.prefix + ' ' + x;
    });
};

var pre = new Prefixer('Hi');
console.log(pre.prefixArray(['Lee', 'Kim']));   // [ 'undefined Lee', 'undefined Kim' ]
