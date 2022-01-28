package io.github.shirohoo.moviereservation.fixture;

import static java.time.LocalDateTime.now;
import io.github.shirohoo.moviereservation.domain.DiscountPolicy;
import io.github.shirohoo.moviereservation.domain.Money;
import io.github.shirohoo.moviereservation.domain.Movie;
import io.github.shirohoo.moviereservation.domain.Screening;
import java.time.Duration;
import java.time.LocalDateTime;

public class DomainFixture {
    public static Screening testScreening(DiscountPolicy discountPolicy) {
        Movie movie = testMovie("titanic", Duration.ofMinutes(150), Money.won(9_900), discountPolicy);
        int sequence = 1;
        LocalDateTime when = now();
        return Screening.of(movie, sequence, when);
    }

    public static Movie testMovie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        return Movie.of(title, runningTime, fee, discountPolicy);
    }
}
