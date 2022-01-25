package io.github.shirohoo.ticketsales.domain;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import org.junit.jupiter.api.Test;

class TicketSellerTests {
    @Test
    void from() {
        TicketOffice ticketOffice = TicketOffice.of(10_000L, Ticket.from(10_000L));
        assertThatCode(() -> TicketSeller.from(ticketOffice))
            .doesNotThrowAnyException();
    }

    @Test
    void sellToHasInvitation() {
        // ...given
        Bag bag = Bag.of(Invitation.from(now()), 10_000L);
        Audience audience = Audience.of(bag);
        TicketOffice ticketOffice = TicketOffice.of(10_000L, Ticket.from(10_000L));
        TicketSeller ticketSeller = TicketSeller.from(ticketOffice);

        // ...when
        ticketSeller.sellTo(audience);

        // ...then
        assertThat(audience.currentAmount()).isEqualTo(10_000L);
        assertThat(ticketOffice.currentAmount()).isEqualTo(10_000L);
    }

    @Test
    void sellToHasNotInvitation() {
        // ...given
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(bag);
        TicketOffice ticketOffice = TicketOffice.of(10_000L, Ticket.from(10_000L));
        TicketSeller ticketSeller = TicketSeller.from(ticketOffice);

        // ...when
        ticketSeller.sellTo(audience);

        // ...then
        assertThat(audience.currentAmount()).isEqualTo(0);
        assertThat(ticketOffice.currentAmount()).isEqualTo(20_000L);
    }
}
