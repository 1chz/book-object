package io.github.shirohoo.ticketsales.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class TicketOfficeTests {
    @Test
    void of() throws Exception {
        assertThatCode(() -> {
            TicketOffice.of(100_000L, newTickets(10_000L));
        }).doesNotThrowAnyException();
    }

    @Test
    void getTicket() throws Exception {
        TicketOffice ticketOffice = TicketOffice.of(100_000L, newTickets(10_000L));
        Ticket ticket = ticketOffice.getTicket();
        assertThat(ticket.getFee()).isEqualTo(10_000L);
    }

    @Test
    void ifHasNotTickets() throws Exception {
        TicketOffice ticketOffice = TicketOffice.of(100_000L, newTickets(10_000L));
        IntStream.range(0, 10).forEach(ticketing -> ticketOffice.getTicket());
        assertThatThrownBy(ticketOffice::getTicket)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void plusAmount() throws Exception {
        TicketOffice ticketOffice = TicketOffice.of(100_000L, newTickets(10_000L));
        assertThatCode(() -> {
            ticketOffice.plusAmount(10_000L);
        }).doesNotThrowAnyException();
        assertThat(ticketOffice.currentAmount()).isEqualTo(110_000L);
    }

    private Ticket[] newTickets(long ticketPrice) throws Exception {
        return IntStream.rangeClosed(0, 9)
                .mapToObj(ticketing -> Ticket.from(ticketPrice))
                .toArray(Ticket[]::new);
    }
}
