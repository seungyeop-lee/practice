package phone.compose;

import money.Money;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        // 일반 요금제
        Phone phone = new Phone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));

        // 심야 할인 요금제
        phone = new Phone(new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10)));

        phone = new Phone(
                new TaxablePolicy(0.05,
                        new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)))
        );

        phone = new Phone(
                new TaxablePolicy(0.05,
                        new RateDiscountablePolicy(Money.wons(1000),
                                new RegularPolicy(Money.wons(10), Duration.ofSeconds(10))))
        );

        phone = new Phone(
                new RateDiscountablePolicy(Money.wons(1000),
                        new TaxablePolicy(0.05,
                                new RegularPolicy(Money.wons(10), Duration.ofSeconds(10))))
        );

        phone = new Phone(
                new RateDiscountablePolicy(Money.wons(1000),
                        new TaxablePolicy(0.05,
                                new NightlyDiscountPolicy(Money.wons(5), Money.wons(10), Duration.ofSeconds(10))))
        );
    }
}
