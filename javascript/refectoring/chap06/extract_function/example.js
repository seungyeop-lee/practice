class _Clock {
    get today() {
        return new Date();
    }
}

let Clock = new _Clock();

export function printOwing(invoice) {
    printBanner();
    const outstanding = calculateOutstanding(invoice);
    recodeDueDate(invoice);
    printDetails(invoice, outstanding);
}

function printBanner() {
    console.log('************************');
    console.log('******* 고객 채무 ********');
    console.log('************************');
}

function calculateOutstanding(invoice) {
    let result = 0;
    for (const o of invoice.orders) {
        result += o.amount;
    }
    return result;
}

function recodeDueDate(invoice) {
    const today = Clock.today;
    invoice.dueDate = new Date(
        today.getFullYear(),
        today.getMonth(),
        today.getDate() + 30
    );
}

function printDetails(invoice, outstanding) {
    console.log(`고객명: ${invoice.customer}`);
    console.log(`채무액: ${outstanding}`);
    console.log(`마감일: ${invoice.dueDate.toLocaleDateString()}`);
}
