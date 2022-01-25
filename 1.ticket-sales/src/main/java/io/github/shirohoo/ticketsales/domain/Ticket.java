package io.github.shirohoo.ticketsales.domain;

public class Ticket {
    private final long fee;

    private Ticket(long fee) {
        if (fee < 0) {
            throw new IllegalArgumentException();
        }
        this.fee = fee;
    }

    public static Ticket from(long fee) {
        return new Ticket(fee);
    }

    public long getFee() {
        return fee;
    }
}
