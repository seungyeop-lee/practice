function inNewEngland(aCustomer) {
    return ['MA', 'CT', 'ME', 'VT', 'NG', 'RI'].includes(
        aCustomer.address.state
    );
}

let someCustomers = [];
const newEnglanders = someCustomers.filter((c) => inNewEngland(c));
