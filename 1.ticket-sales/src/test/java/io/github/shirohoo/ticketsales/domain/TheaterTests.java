package io.github.shirohoo.ticketsales.domain;

import org.junit.jupiter.api.Test;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class TheaterTests {
    @Test
    void from() {
        TicketOffice ticketOffice = TicketOffice.of(0, Ticket.from(10_000L));
        TicketSeller ticketSeller = TicketSeller.from(ticketOffice);
        assertThatCode(() -> {
            Theater.from(ticketSeller);
        }).doesNotThrowAnyException();
    }

    @Test
    void enterHasInvitation() {
        // ...given
        Bag bag = Bag.of(Invitation.from(now()), 10_000L);
        Audience audience = Audience.of(null, bag);
        TicketOffice ticketOffice = TicketOffice.of(0L, Ticket.from(10_000L));
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
    void enterHasNotInvitation() {
        // ...given
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(null, bag);
        TicketOffice ticketOffice = TicketOffice.of(0L, Ticket.from(10_000L));
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
