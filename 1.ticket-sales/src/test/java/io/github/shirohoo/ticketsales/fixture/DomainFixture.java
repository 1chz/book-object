package io.github.shirohoo.ticketsales.fixture;

import io.github.shirohoo.ticketsales.domain.*;
import io.github.shirohoo.ticketsales.port.out.PerformanceAttributes;

import java.util.Set;
import java.util.stream.IntStream;

public class DomainFixture {
    public static final Ticket TICKET_10000 = Ticket.from(10_000L);

    public static PerformanceAttributes performanceAttributes() {
        return new PerformanceAttributes() {
            @Override
            public Set<Audience> getAudiences() {
                Bag bag = Bag.from(10_000L);
                return Set.of(
                        Audience.of(null, bag),
                        Audience.of(null, bag),
                        Audience.of(null, bag),
                        Audience.of(null, bag),
                        Audience.of(null, bag)
                );
            }

            @Override
            public Genre getGenre() {
                return Genre.COMEDY;
            }

            @Override
            public long getProfit() {
                return getAudiences()
                        .stream()
                        .map(Audience::currentAmount)
                        .reduce(0L, Long::sum);
            }
        };
    }

    public static Set<Audience> audiences() {
        Bag bag = Bag.from(10_000L);
        return Set.of(
                Audience.of(null, bag),
                Audience.of(null, bag),
                Audience.of(null, bag),
                Audience.of(null, bag),
                Audience.of(null, bag)
        );
    }

    public static TicketOffice ticketOfficeComedy() {
        return TicketOffice.of(Genre.COMEDY, 0L, newTickets(10_000L));
    }

    private static Ticket[] newTickets(long ticketPrice) {
        return IntStream.rangeClosed(0, 9)
                .mapToObj(ticketing -> Ticket.from(ticketPrice))
                .toArray(Ticket[]::new);
    }
}
