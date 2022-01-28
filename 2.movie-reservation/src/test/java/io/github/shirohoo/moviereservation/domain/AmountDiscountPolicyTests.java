package io.github.shirohoo.moviereservation.domain;

import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testScreening;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import org.junit.jupiter.api.Test;

class AmountDiscountPolicyTests {
    @Test
    void of() {
        assertThatCode(() -> {
            Money discountAmount = Money.won(1_000);
            DiscountCondition condition = SequenceDiscountCondition.from(1);
            AmountDiscountPolicy.of(discountAmount, condition);
        }).doesNotThrowAnyException();
    }

    @Test
    void getDiscountAmount() {
        // ...given
        Money discountAmount = Money.won(1_000);
        DiscountCondition condition = SequenceDiscountCondition.from(1);

        // ...when
        AmountDiscountPolicy discountPolicy = AmountDiscountPolicy.of(discountAmount, condition);

        // ...then
        assertThat(discountPolicy.getDiscountAmount(testScreening())).isEqualTo(discountAmount);
    }
}