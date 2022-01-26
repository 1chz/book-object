package io.github.shirohoo.ticketsales.port.out;

import io.github.shirohoo.ticketsales.domain.Audience;
import io.github.shirohoo.ticketsales.domain.Genre;

import java.util.Set;

public interface PerformanceAttributes {
    Set<Audience> getAudiences();

    Genre getGenre();

    long getProfit();
}
