package io.github.shirohoo.ticketsales.domain;

import org.junit.jupiter.api.Test;

import static io.github.shirohoo.ticketsales.fixture.DomainFixture.TICKET_10000;
import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class AudienceTests {
    @Test
    void of() throws Exception {
        Bag bag = Bag.from(10_000L);
        assertThatCode(() -> {
            Audience.of(null, bag);
        }).doesNotThrowAnyException();
    }

    @Test
    void currentAmount() throws Exception {
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(null, bag);
        assertThat(audience.currentAmount()).isEqualTo(10_000L);
    }

    @Test
    void hasInvitationTrue() throws Exception {
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(null, bag);
        assertThat(audience.hasInvitation()).isFalse();
    }

    @Test
    void hasInvitationFalse() throws Exception {
        Bag bag = Bag.of(Invitation.from(now()), 10_000L);
        Audience audience = Audience.of(null, bag);
        assertThat(audience.hasInvitation()).isTrue();
    }

    @Test
    void hasTicket() throws Exception {
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(null, bag);
        assertThat(audience.hasTicket()).isFalse();
    }

    @Test
    void buy() throws Exception {
        // ...given
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(null, bag);
        Ticket ticket = TICKET_10000;

        // ...when
        long salesProceeds = audience.buy(ticket);

        // ...then
        assertThat(salesProceeds).isEqualTo(ticket.getFee());
        assertThat(audience.hasTicket()).isTrue();
        assertThat(audience.currentAmount()).isEqualTo(0L);
    }

    @Test
    void getId() throws Exception {
        Bag bag = Bag.from(10_000L);
        Audience audience = Audience.of(1L, bag);
        assertThat(audience.getId()).isEqualTo(1L);
    }
}
