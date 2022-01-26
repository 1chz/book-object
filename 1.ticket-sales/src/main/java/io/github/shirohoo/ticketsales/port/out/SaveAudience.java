package io.github.shirohoo.ticketsales.port.out;

import io.github.shirohoo.ticketsales.domain.Audience;

public interface SaveAudience {
    Audience save(Audience audience);
}
