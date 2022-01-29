package io.github.shirohoo.moviereservation.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

    @MethodSource
    @ParameterizedTest
    void isSatisfiedBy(int hour, boolean expected) throws Exception {
        // ...given
        LocalDateTime baseSalePeriod = getLocalDateTime().plusHours(hour);
        DayOfWeek saleDay = baseSalePeriod.getDayOfWeek();
        LocalTime saleStartTime = baseSalePeriod.toLocalTime().minusHours(2);
        LocalTime saleEndTime = baseSalePeriod.toLocalTime().plusHours(2);

        // ...when
        PeriodDiscountCondition condition = PeriodDiscountCondition.of(saleDay, saleStartTime, saleEndTime);

        // ...then
        assertThat(condition.isSatisfiedBy(screening())).isEqualTo(expected);
    }

    static Stream<Arguments> isSatisfiedBy() {
        return Stream.of(
            Arguments.of(3, false),
            Arguments.of(6, true),
            Arguments.of(9, false)
        );
    }

    private Screening screening() {
        LocalDateTime whenScreened = getLocalDateTime().plusHours(6);
        Movie titanic = Movie.of("titanic", Duration.ofMinutes(150), Money.won(9_900), new NoneDiscountPolicy());
        return Screening.of(titanic, 1, whenScreened);
    }

    private LocalDateTime getLocalDateTime() {
        return LocalDate.of(2000, 1, 1).atStartOfDay();
    }
}