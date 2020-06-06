function Prefixer(prefix) {
    this.prefix = prefix;
}

Prefixer.prototype.prefixArray = function (arr) {
    return arr.map(function (x) {
        return this.prefix + ' ' + x;
    }.bind(this));
};

var pre = new Prefixer('Hi');
console.log(pre.prefixArray(['Lee', 'Kim']));   // [ 'Hi Lee', 'Hi Kim' ]
