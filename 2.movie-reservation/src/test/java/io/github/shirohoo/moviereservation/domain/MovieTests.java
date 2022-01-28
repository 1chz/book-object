package io.github.shirohoo.moviereservation.domain;

import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testMovie;
import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testScreening;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.time.Duration;
import org.junit.jupiter.api.Test;

class MovieTests {
    @Test
    void of() throws Exception {
        assertThatCode(() -> {
            String title = "titanic";
            Duration runningTime = Duration.ofMinutes(150);
            Money fee = Money.won(9_900);
            DiscountPolicy discountPolicy = new NoneDefaultDiscountPolicy();
            Movie.of(title, runningTime, fee, discountPolicy);
        }).doesNotThrowAnyException();
    }

    @Test
    void ofException() throws Exception {
        assertThatThrownBy(() -> {
            String title = "titanic";
            Duration runningTime = Duration.ofMinutes(150);
            Money fee = Money.won(-1);
            DiscountPolicy discountPolicy = new NoneDefaultDiscountPolicy();
            Movie.of(title, runningTime, fee, discountPolicy);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void getFee() throws Exception {
        // ...given
        String title = "titanic";
        Duration runningTime = Duration.ofMinutes(150);
        Money fee = Money.won(9_900);
        DiscountPolicy discountPolicy = new NoneDefaultDiscountPolicy();

        // ...when
        Movie movie = Movie.of(title, runningTime, fee, discountPolicy);

        // ...then
        assertThat(movie.getFee()).isEqualTo(fee);
    }

    @Test
    void calculateMovieFee() throws Exception {
        String title = "titanic";
        Duration runningTime = Duration.ofMinutes(150);
        Money fee = Money.won(9_900);
        DiscountPolicy discountPolicy = new NoneDefaultDiscountPolicy();

        // ...when
        Movie movie = Movie.of(title, runningTime, fee, discountPolicy);

        // ...then
        assertThat(movie.calculateMovieFee(testScreening(testMovie()))).isEqualTo(fee);
    }

    @Test
    void setDiscountPolicy() throws Exception {
        String title = "titanic";
        Duration runningTime = Duration.ofMinutes(150);
        Money fee = Money.won(9_900);
        DiscountPolicy discountPolicy = new NoneDefaultDiscountPolicy();
        Movie movie = Movie.of(title, runningTime, fee, discountPolicy);

        // ...when
        movie.setDiscountPolicy(new PercentDefaultDiscountPolicy(10));

        // ...then
        assertThat(movie.calculateMovieFee(testScreening(testMovie()))).isEqualTo(fee);
    }
}