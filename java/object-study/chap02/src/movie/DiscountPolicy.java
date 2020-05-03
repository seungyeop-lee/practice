package movie;

import money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
