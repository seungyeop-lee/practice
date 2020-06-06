var funcs = [];

for (var i = 0; i < 3; i++) {
    funcs.push(function() {
        console.log(i);});
}

for (var j = 0; j < 3; j++) {
    funcs[j]();
}

// output:
// 3
// 3
// 3
