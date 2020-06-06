function Prefixer(prefix) {
    this.prefix = prefix;
}

Prefixer.prototype.prefixArray = function (arr) {
    var that = this;
    return arr.map(function (x) {
        return that.prefix + ' ' + x;
    });
};

var pre = new Prefixer('Hi');
console.log(pre.prefixArray(['Lee', 'Kim']));   // [ 'Hi Lee', 'Hi Kim' ]
