var funcs = [];

for (let i = 0; i < 3; i++) {
    funcs.push(function() {
        console.log(i);});
}

for (var j = 0; j < 3; j++) {
    funcs[j]();
}

// output:
// 0
// 1
// 2
