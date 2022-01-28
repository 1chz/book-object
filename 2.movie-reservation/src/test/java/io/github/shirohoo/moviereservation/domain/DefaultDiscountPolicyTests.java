package io.github.shirohoo.moviereservation.domain;

import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testScreening;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class DefaultDiscountPolicyTests {
    @Test
    void amountDiscountAmountCalculateSequenceCondition() throws Exception {
        // ...given
        SequenceDiscountCondition condition = SequenceDiscountCondition.from(1);
        AmountDiscountPolicy discountPolicy = AmountDiscountPolicy.of(Money.won(1_000), condition);

        // ...when
        Money discountAmount = discountPolicy.calculateDiscountAmount(testScreening());

        // ...then
        assertThat(discountAmount).isEqualTo(Money.won(1_000));
    }

    @Test
    void percentDiscountAmountCalculateSequenceCondition() throws Exception {
        // ...given
        SequenceDiscountCondition condition = SequenceDiscountCondition.from(1);
        PercentDiscountPolicy discountPolicy = PercentDiscountPolicy.of(10.0, condition);

        // ...when
        Money discountAmount = discountPolicy.calculateDiscountAmount(testScreening());

        // ...then
        assertThat(discountAmount).isEqualTo(Money.won(990.0));
    }

    @Test
    void amountDiscountAmountCalculateSequenceConditionIfNot() throws Exception {
        // ...given
        SequenceDiscountCondition condition = SequenceDiscountCondition.from(2);
        AmountDiscountPolicy discountPolicy = AmountDiscountPolicy.of(Money.won(1_000), condition);

        // ...when
        Money discountAmount = discountPolicy.calculateDiscountAmount(testScreening());

        // ...then
        assertThat(discountAmount).isEqualTo(Money.ZERO);
    }

    @Test
    void percentDiscountAmountCalculateSequenceConditionIfNot() throws Exception {
        // ...given
        SequenceDiscountCondition condition = SequenceDiscountCondition.from(2);
        PercentDiscountPolicy discountPolicy = PercentDiscountPolicy.of(10.0, condition);

        // ...when
        Money discountAmount = discountPolicy.calculateDiscountAmount(testScreening());

        // ...then
        assertThat(discountAmount).isEqualTo(Money.ZERO);
    }

    @Test
    void amountDiscountAmountCalculatePeriodCondition() throws Exception {
        // ...given
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalTime startTime = now.toLocalTime();
        LocalTime endTime = now.toLocalTime().plusMinutes(150);
        PeriodDiscountCondition condition = PeriodDiscountCondition.of(dayOfWeek, startTime, endTime);
        AmountDiscountPolicy discountPolicy = AmountDiscountPolicy.of(Money.won(1_000), condition);

        // ...when
        Money discountAmount = discountPolicy.calculateDiscountAmount(testScreening());

        // ...then
        assertThat(discountAmount).isEqualTo(Money.won(1_000));
    }

    @Test
    void percentDiscountAmountCalculatePeriodCondition() throws Exception {
        // ...given
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalTime startTime = now.toLocalTime();
        LocalTime endTime = now.toLocalTime().plusMinutes(150);
        PeriodDiscountCondition condition = PeriodDiscountCondition.of(dayOfWeek, startTime, endTime);
        PercentDiscountPolicy discountPolicy = PercentDiscountPolicy.of(10.0, condition);

        // ...when
        Money discountAmount = discountPolicy.calculateDiscountAmount(testScreening());

        // ...then
        assertThat(discountAmount).isEqualTo(Money.won(990.0));
    }

    @Test
    void amountDiscountAmountCalculatePeriodConditionIfNot() throws Exception {
        // ...given
        LocalDateTime now = LocalDateTime.now().minusDays(1);
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalTime startTime = now.toLocalTime();
        LocalTime endTime = now.toLocalTime();
        PeriodDiscountCondition condition = PeriodDiscountCondition.of(dayOfWeek, startTime, endTime);
        AmountDiscountPolicy discountPolicy = AmountDiscountPolicy.of(Money.won(1_000), condition);

        // ...when
        Money discountAmount = discountPolicy.calculateDiscountAmount(testScreening());

        // ...then
        assertThat(discountAmount).isEqualTo(Money.ZERO);
    }

    @Test
    void percentDiscountAmountCalculatePeriodConditionIfNot() throws Exception {
        // ...given
        LocalDateTime now = LocalDateTime.now().minusDays(1);
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalTime startTime = now.toLocalTime();
        LocalTime endTime = now.toLocalTime();
        PeriodDiscountCondition condition = PeriodDiscountCondition.of(dayOfWeek, startTime, endTime);
        PercentDiscountPolicy discountPolicy = PercentDiscountPolicy.of(10.0, condition);

        // ...when
        Money discountAmount = discountPolicy.calculateDiscountAmount(testScreening());

        // ...then
        assertThat(discountAmount).isEqualTo(Money.ZERO);
    }
}