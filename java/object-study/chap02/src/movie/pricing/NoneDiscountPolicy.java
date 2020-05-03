package movie.pricing;

import money.Money;
import movie.DiscountPolicy;
import movie.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
