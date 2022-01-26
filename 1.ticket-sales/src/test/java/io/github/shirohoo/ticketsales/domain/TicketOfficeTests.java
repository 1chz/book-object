package io.github.shirohoo.ticketsales.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static io.github.shirohoo.ticketsales.fixture.DomainFixture.TICKET_10000;
import static io.github.shirohoo.ticketsales.fixture.DomainFixture.ticketOfficeComedy;
import static org.assertj.core.api.Assertions.*;

class TicketOfficeTests {
    @Test
    void of() throws Exception {
        assertThatCode(() -> {
            TicketOffice.of(Genre.COMEDY, 0L, TICKET_10000);
        }).doesNotThrowAnyException();
    }

    @Test
    void getTicket() throws Exception {
        TicketOffice ticketOffice = ticketOfficeComedy();
        Ticket ticket = ticketOffice.getTicket();
        assertThat(ticket.getFee()).isEqualTo(10_000L);
    }

    @Test
    void ifHasNotTickets() throws Exception {
        TicketOffice ticketOffice = ticketOfficeComedy();
        IntStream.range(0, 10).forEach(ticketing -> ticketOffice.getTicket());
        assertThatThrownBy(ticketOffice::getTicket)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void plusAmount() throws Exception {
        TicketOffice ticketOffice = ticketOfficeComedy();
        assertThatCode(() -> {
            ticketOffice.plusAmount(10_000L);
        }).doesNotThrowAnyException();
        assertThat(ticketOffice.currentAmount()).isEqualTo(10_000L);
    }

    @Test
    void getGenre() throws Exception {
        TicketOffice ticketOffice = ticketOfficeComedy();
        assertThat(ticketOffice.getGenre()).isEqualTo(Genre.COMEDY);
    }
}
