package io.github.shirohoo.moviereservation.domain;

import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testScreening;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;

class PeriodDiscountConditionTests {
    @Test
    void of() throws Exception {
        assertThatCode(() -> {
            LocalDateTime now = LocalDateTime.now();
            DayOfWeek dayOfWeek = now.getDayOfWeek();
            LocalTime startTime = now.toLocalTime().minusHours(2);
            LocalTime endTime = now.toLocalTime().plusHours(2);
            PeriodDiscountCondition.of(dayOfWeek, startTime, endTime);
        }).doesNotThrowAnyException();

    }

    @Test
    void isSatisfiedBy() throws Exception {
        // ...given
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        LocalTime startTime = now.toLocalTime().minusHours(2);
        LocalTime endTime = now.toLocalTime().plusHours(2);

        // ...when
        PeriodDiscountCondition condition = PeriodDiscountCondition.of(dayOfWeek, startTime, endTime);

        // ...then
        assertThat(condition.isSatisfiedBy(testScreening())).isTrue();
    }
}