package io.github.shirohoo.moviereservation.domain;

import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testScreening;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class PercentDiscountPolicyTests {
    @Test
    void getDiscountAmount() {
        PercentDiscountPolicy percentDiscountPolicy = new PercentDiscountPolicy(10.0);
        Money discountAmount = percentDiscountPolicy.getDiscountAmount(testScreening());
        assertThat(discountAmount).isEqualTo(Money.won(990.0));
    }
}