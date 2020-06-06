var funcs = [];

for (var i = 0; i < 3; i++) {
    (function(index) {
        funcs.push(function() {
            console.log(index);});
    })(i);
}

for (var j = 0; j < 3; j++) {
    funcs[j]();
}

// output:
// 0
// 1
// 2
