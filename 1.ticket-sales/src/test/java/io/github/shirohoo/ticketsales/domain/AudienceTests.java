package io.github.shirohoo.ticketsales.domain;

import org.junit.jupiter.api.Test;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class AudienceTests {
    @Test
    void of() {
        Bag bag = Bag.from(10_000L);
        assertThatCode(() -> {
            Audience.of(null, bag);
        }).doesNotThrowAnyException();
    }

    @Test
    void currentAmount() {
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(null, bag);
        assertThat(audience.currentAmount()).isEqualTo(10_000L);
    }

    @Test
    void hasInvitationTrue() {
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(null, bag);
        assertThat(audience.hasInvitation()).isFalse();
    }

    @Test
    void hasInvitationFalse() {
        Bag bag = Bag.of(Invitation.from(now()), 10_000L);
        Audience audience = Audience.of(null, bag);
        assertThat(audience.hasInvitation()).isTrue();
    }

    @Test
    void hasTicket() {
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(null, bag);
        assertThat(audience.hasTicket()).isFalse();
    }

    @Test
    void buy() throws Exception {
        // ...given
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(null, bag);
        Ticket ticket = Ticket.from(10_000L);

        // ...when
        long salesProceeds = audience.buy(ticket);

        // ...then
        assertThat(salesProceeds).isEqualTo(ticket.getFee());
        assertThat(audience.hasTicket()).isTrue();
        assertThat(audience.currentAmount()).isEqualTo(0L);
    }
}
