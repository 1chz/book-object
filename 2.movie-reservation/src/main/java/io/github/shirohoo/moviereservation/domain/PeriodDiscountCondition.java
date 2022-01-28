package io.github.shirohoo.moviereservation.domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PeriodDiscountCondition implements DiscountCondition {
    private final DayOfWeek dayOfWeek;
    private final LocalTime startTime;
    private final LocalTime endTime;

    private PeriodDiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static PeriodDiscountCondition of(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        return new PeriodDiscountCondition(dayOfWeek, startTime, endTime);
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        LocalDateTime startTime = screening.getStartTime();
        boolean equals = startTime.getDayOfWeek().equals(dayOfWeek);
        boolean before = this.startTime.isBefore(startTime.toLocalTime());
        boolean after = this.endTime.isAfter(startTime.toLocalTime());
        return equals && before && after;
    }
}
