package phone;

import money.Money;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
