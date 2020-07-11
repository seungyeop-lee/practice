function inNewEngland(stateCode) {
    ['MA', 'CT', 'ME', 'VT', 'NG', 'RI'].includes(stateCode);
}

let someCustomers = [];
const newEnglanders = someCustomers.filter((c) => inNewEngland(c));
