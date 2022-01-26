package io.github.shirohoo.ticketsales.domain;

import org.junit.jupiter.api.Test;

import static io.github.shirohoo.ticketsales.fixture.DomainFixture.ticketOfficeComedy;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class TheaterTests {
    @Test
    void from() throws Exception {
        TicketOffice ticketOffice = ticketOfficeComedy();
        TicketSeller ticketSeller = TicketSeller.from(ticketOffice);
        assertThatCode(() -> {
            Theater.from(ticketSeller);
        }).doesNotThrowAnyException();
    }

    @Test
    void enterHasInvitation() throws Exception {
        // ...given
        Bag bag = Bag.of(Invitation.from(now()), 10_000L);
        Audience audience = Audience.of(null, bag);
        TicketOffice ticketOffice = ticketOfficeComedy();
        TicketSeller ticketSeller = TicketSeller.from(ticketOffice);
        Theater theater = Theater.from(ticketSeller);

        // ...when
        theater.enter(audience);

        // ...then
        assertThat(audience.hasTicket()).isTrue();
        assertThat(audience.currentAmount()).isEqualTo(10_000L);
        assertThat(ticketOffice.currentAmount()).isEqualTo(0L);
    }

    @Test
    void enterHasNotInvitation() throws Exception {
        // ...given
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(null, bag);
        TicketOffice ticketOffice = ticketOfficeComedy();
        TicketSeller ticketSeller = TicketSeller.from(ticketOffice);
        Theater theater = Theater.from(ticketSeller);

        // ...when
        theater.enter(audience);

        // ...then
        assertThat(audience.hasTicket()).isTrue();
        assertThat(audience.currentAmount()).isEqualTo(0L);
        assertThat(ticketOffice.currentAmount()).isEqualTo(10_000L);
    }
}
