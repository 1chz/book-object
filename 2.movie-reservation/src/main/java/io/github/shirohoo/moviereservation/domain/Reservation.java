package io.github.shirohoo.moviereservation.domain;

public class Reservation {
    private final Customer customer;
    private final Screening screening;
    private final Money fee;
    private final int audienceCount;

    private Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

    public static Reservation of(Customer customer, Screening screening, Money fee, int audienceCount) {
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
