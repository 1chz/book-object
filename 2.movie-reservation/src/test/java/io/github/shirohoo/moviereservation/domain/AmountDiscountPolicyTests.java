package io.github.shirohoo.moviereservation.domain;

import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testScreening;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import org.junit.jupiter.api.Test;

class AmountDiscountPolicyTests {
    @Test
    void of() throws Exception {
        assertThatCode(() -> {
            Money discountAmount = Money.won(1_000);
            DiscountCondition condition = SequenceDiscountCondition.from(1);
            AmountDiscountPolicy.of(discountAmount, condition);
        }).doesNotThrowAnyException();
    }

    @Test
    void getDiscountAmount() throws Exception {
        // ...given
        DiscountCondition condition = SequenceDiscountCondition.from(1);
        AmountDiscountPolicy discountPolicy = AmountDiscountPolicy.of(Money.won(1_000), condition);

        // ...when
        Money discountAmount = discountPolicy.getDiscountAmount(testScreening());

        // ...then
        assertThat(discountAmount).isEqualTo(Money.won(1_000));
    }
}