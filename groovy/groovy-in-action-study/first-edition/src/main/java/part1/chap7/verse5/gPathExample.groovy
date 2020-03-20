package part1.chap7.verse5

class Invoice {
    List items
    Date date
}

class LineItem {
    Product product
    int count
    int total() {
        return product.dollar * count
    }
}

class Product {
    String name
    def dollar
}

def ulcDate = new Date(107, 0, 1)
def ulc = new Product(dollar: 1499, name: 'ULC')
def ve = new Product(dollar: 499, name: 'Visual Editor')

def invoices = [
        new Invoice(date: ulcDate, items: [
                new LineItem(count: 5, product: ulc),
                new LineItem(count: 1, product: ve)
        ]),
        new Invoice(date: [107,1,2], items: [
                new LineItem(count: 4, product: ve)
        ])
]

assert [5*1499, 499, 4*499] == invoices.items.flatten()*.total()

assert ['ULC'] == invoices.items.flatten().grep{ it.total() > 7000 }.product.name

def searchDates = invoices.grep {
    it.items.any { it.product == ulc }
}.date*.toString()
assert [ulcDate.toString()] == searchDates