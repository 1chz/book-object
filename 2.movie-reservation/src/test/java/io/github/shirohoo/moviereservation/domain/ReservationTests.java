package io.github.shirohoo.moviereservation.domain;

import static io.github.shirohoo.moviereservation.fixture.DomainFixture.testScreening;
import static org.assertj.core.api.Assertions.assertThatCode;
import org.junit.jupiter.api.Test;

class ReservationTests {
    @Test
    void of() {
        assertThatCode(() -> {
            Customer customer = Customer.newCustomer("name");
            Screening screening = testScreening();
            Money money = Money.won(10_000);
            int audienceCount = 1;
            Reservation.of(customer, screening, money, audienceCount);
        }).doesNotThrowAnyException();
    }
}