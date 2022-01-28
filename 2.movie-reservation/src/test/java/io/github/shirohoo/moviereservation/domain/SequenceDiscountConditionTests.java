package io.github.shirohoo.moviereservation.domain;

import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testMovie;
import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testScreening;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class SequenceDiscountConditionTests {
    @Test
    void from() throws Exception {
        assertThatCode(() -> {
            SequenceDiscountCondition.from(1);
        }).doesNotThrowAnyException();
    }

    @Test
    void fromException() throws Exception {
        assertThatThrownBy(() -> {
            SequenceDiscountCondition.from(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isSatisfiedBy() throws Exception {
        Screening screening = testScreening(testMovie());
        SequenceDiscountCondition discountCondition = SequenceDiscountCondition.from(1);
        assertThat(discountCondition.isSatisfiedBy(screening)).isTrue();
    }
}