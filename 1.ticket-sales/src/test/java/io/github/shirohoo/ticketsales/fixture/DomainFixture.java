package io.github.shirohoo.ticketsales.fixture;

import io.github.shirohoo.ticketsales.domain.Genre;
import io.github.shirohoo.ticketsales.domain.Ticket;
import io.github.shirohoo.ticketsales.domain.TicketOffice;

import java.util.stream.IntStream;

public class DomainFixture {
    public static final Ticket TICKET_10000 = Ticket.from(10_000L);

    public static TicketOffice ticketOfficeComedy() {
        return TicketOffice.of(Genre.COMEDY, 0L, newTickets(10_000L));
    }

    private static Ticket[] newTickets(long ticketPrice) {
        return IntStream.rangeClosed(0, 9)
                .mapToObj(ticketing -> Ticket.from(ticketPrice))
                .toArray(Ticket[]::new);
    }
}
