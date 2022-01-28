package io.github.shirohoo.moviereservation.domain;

import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testMovie;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class ScreeningTests {
    @Test
    void of() throws Exception {
        assertThatCode(() -> {
            Screening.of(testMovie(), 1, now());
        }).doesNotThrowAnyException();
    }

    @Test
    void getStartTime() throws Exception {
        LocalDateTime whenScreened = LocalDate.of(2000, 1, 1).atStartOfDay();
        Screening screening = Screening.of(testMovie(), 1, whenScreened);
        assertThat(screening.getStartTime()).isEqualTo(whenScreened);
    }

    @Test
    void isSequence() throws Exception {
        LocalDateTime whenScreened = LocalDate.of(2000, 1, 1).atStartOfDay();
        Screening screening = Screening.of(testMovie(), 1, whenScreened);
        assertThat(screening.isSequence(1)).isTrue();
        assertThat(screening.isSequence(2)).isFalse();
    }

    @Test
    void getMovieFee() throws Exception {
        LocalDateTime whenScreened = LocalDate.of(2000, 1, 1).atStartOfDay();
        Screening screening = Screening.of(testMovie(), 1, whenScreened);
        assertThat(screening.getMovieFee()).isEqualTo(Money.won(9_900));
    }

    @Test
    void reserve() throws Exception {
        // ...given
        LocalDateTime whenScreened = LocalDate.of(2000, 1, 1).atStartOfDay();
        Screening screening = Screening.of(testMovie(), 1, whenScreened);

        // ...when
        Reservation reservation = screening.reserve(Customer.newCustomer("name"), 1);

        // ...then
        assertThat(reservation).isNotNull();
    }
}