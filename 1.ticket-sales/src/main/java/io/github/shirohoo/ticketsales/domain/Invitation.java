package io.github.shirohoo.ticketsales.domain;

import java.time.LocalDateTime;

public record Invitation(LocalDateTime when) {
    public static Invitation from(LocalDateTime when) {
        return new Invitation(when);
    }
}
