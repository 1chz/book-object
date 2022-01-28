package io.github.shirohoo.moviereservation.fixture;

import static java.time.LocalDateTime.now;
import io.github.shirohoo.moviereservation.domain.DiscountPolicy;
import io.github.shirohoo.moviereservation.domain.Money;
import io.github.shirohoo.moviereservation.domain.Movie;
import io.github.shirohoo.moviereservation.domain.NoneDefaultDiscountPolicy;
import io.github.shirohoo.moviereservation.domain.Screening;
import java.time.Duration;

public class DomainFixture {
    public static Screening testScreening(Movie movie) {
        return Screening.of(movie, 1, now());
    }

    public static Movie testMovie() {
        return testMovie("titanic", Duration.ofMinutes(150), Money.won(9_900), new NoneDefaultDiscountPolicy());
    }

    public static Movie testMovie(Duration runningTime) {
        return testMovie("titanic", runningTime, Money.won(9_900), new NoneDefaultDiscountPolicy());
    }

    public static Movie testMovie(Money fee) {
        return testMovie("titanic", Duration.ofMinutes(150), fee, new NoneDefaultDiscountPolicy());
    }

    public static Movie testMovie(NoneDefaultDiscountPolicy discountPolicy) {
        return testMovie("titanic", Duration.ofMinutes(150), Money.won(9_900), discountPolicy);
    }

    public static Movie testMovie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        return Movie.of(title, runningTime, fee, discountPolicy);
    }
}
