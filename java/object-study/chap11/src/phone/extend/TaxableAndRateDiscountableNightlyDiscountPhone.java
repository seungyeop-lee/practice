package phone.extend;

import money.Money;

import java.time.Duration;

public class TaxableAndRateDiscountableNightlyDiscountPhone extends TaxableNightlyDiscountPhone {
    private Money discountAmount;

    public TaxableAndRateDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate, Money discountAmount) {
        super(nightlyAmount, regularAmount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}
