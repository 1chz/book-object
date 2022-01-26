package io.github.shirohoo.ticketsales.adapter.out.persistence;

import io.github.shirohoo.ticketsales.domain.Audience;
import io.github.shirohoo.ticketsales.domain.Genre;
import io.github.shirohoo.ticketsales.domain.TicketOffice;
import io.github.shirohoo.ticketsales.port.out.PerformanceAttributes;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class PerformanceAttributesImpl implements PerformanceAttributes {
    private final TicketOffice ticketOffice;
    private final Set<Audience> audiences;

    @Override
    public Set<Audience> getAudiences() {
        return audiences;
    }

    @Override
    public Genre getGenre() {
        return ticketOffice.getGenre();
    }

    @Override
    public long getProfit() {
        return ticketOffice.currentAmount();
    }
}
