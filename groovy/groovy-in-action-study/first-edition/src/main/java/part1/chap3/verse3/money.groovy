package part1.chap3.verse3

class Money {
    private int amount  // 양
    private String currency // 통화 종류

    Money(amountValue, currencyValue) {
        amount = amountValue
        currency = currencyValue
    }

    @Override
    boolean equals(Object other) {
        if (null == other) return false
        if (!(other instanceof Money)) return false
        if (currency != other.currency) return false
        if (amount != other.amount) return false
        return true
    }

    @Override
    int hashCode() {
        amount.hashCode() + currency.hashCode()
    }

    Money plus(Money other) {   // '+' 연산자 재정의 (Money 인스턴스의 '+' 연산)
        if (null == other) return null
        if (other.currency != currency) {   // 통화가 다를경우 예외발생
            throw new IllegalArgumentException("cannot add $other.currency to $currency")
        }
        return new Money(amount + other.amount, currency)
    }

    Money plus(Integer more) {  // '+' 연산자 재정의 (Integer의 '+' 연산)
        if (null == more) return new Money(amount, currency)
        return new Money(amount + more, currency)
    }
}

def buck = new Money(1, 'USD')
assert buck
assert buck == new Money(1, 'USD')
assert buck + buck == new Money(2, 'USD')
assert buck + 1 == new Money(2, 'USD')
