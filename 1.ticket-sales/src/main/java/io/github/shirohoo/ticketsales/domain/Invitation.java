package io.github.shirohoo.ticketsales.domain;

import java.time.LocalDateTime;

public class Invitation {
    private final LocalDateTime when;

    private Invitation(LocalDateTime when) {
        this.when = when;
    }

    public static Invitation from(LocalDateTime when) {
        return new Invitation(when);
    }

    public LocalDateTime when() {
        return when;
    }
}
