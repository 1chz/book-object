package io.github.shirohoo.ticketsales.domain;

import org.junit.jupiter.api.Test;

import static io.github.shirohoo.ticketsales.fixture.DomainFixture.ticketOfficeComedy;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class TicketSellerTests {
    @Test
    void from() throws Exception {
        TicketOffice ticketOffice = ticketOfficeComedy();
        assertThatCode(() -> {
            TicketSeller.from(ticketOffice);
        }).doesNotThrowAnyException();
    }

    @Test
    void sellToHasInvitation() throws Exception {
        // ...given
        Bag bag = Bag.of(Invitation.from(now()), 10_000L);
        Audience audience = Audience.of(null, bag);
        TicketOffice ticketOffice = ticketOfficeComedy();
        TicketSeller ticketSeller = TicketSeller.from(ticketOffice);

        // ...when
        ticketSeller.sellTo(audience);

        // ...then
        assertThat(audience.currentAmount()).isEqualTo(10_000L);
        assertThat(ticketOffice.currentAmount()).isEqualTo(0L);
    }

    @Test
    void sellToHasNotInvitation() throws Exception {
        // ...given
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(null, bag);
        TicketOffice ticketOffice = ticketOfficeComedy();
        TicketSeller ticketSeller = TicketSeller.from(ticketOffice);

        // ...when
        ticketSeller.sellTo(audience);

        // ...then
        assertThat(audience.currentAmount()).isEqualTo(0);
        assertThat(ticketOffice.currentAmount()).isEqualTo(10_000L);
    }
}
