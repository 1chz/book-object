package io.github.shirohoo.moviereservation.domain;

import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testScreening;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import org.junit.jupiter.api.Test;

class PercentDiscountPolicyTests {
    @Test
    void of() throws Exception {
        assertThatCode(() -> {
            PercentDiscountPolicy.of(10.0);
        }).doesNotThrowAnyException();
    }

    @Test
    void getDiscountAmount() throws Exception {
        PercentDiscountPolicy percentDiscountPolicy = PercentDiscountPolicy.of(10.0);
        Money discountAmount = percentDiscountPolicy.getDiscountAmount(testScreening());
        assertThat(discountAmount).isEqualTo(Money.won(990.0));
    }
}