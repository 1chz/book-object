package io.github.shirohoo.ticketsales.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TicketTests {
    @Test
    void from() throws Exception {
        assertThatCode(() -> {
            Ticket.from(10_000L);
        }).doesNotThrowAnyException();
    }

    @Test
    void fromException() throws Exception {
        assertThatThrownBy(() -> {
            Ticket.from(-1L);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getFee() throws Exception {
        Ticket ticket = Ticket.from(10_000L);
        assertThat(ticket.getFee()).isEqualTo(10_000L);
    }
}
