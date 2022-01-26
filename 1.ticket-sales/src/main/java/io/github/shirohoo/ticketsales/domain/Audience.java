package io.github.shirohoo.ticketsales.domain;

public class Audience {
    private final Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public static Audience of(Bag bag) {
        return new Audience(bag);
    }

    public long buy(Ticket ticket) {
        return bag.hold(ticket);
    }

    public boolean hasInvitation() {
        return bag.hasInvitation();
    }

    public boolean hasTicket() {
        return bag.hasTicket();
    }

    public long currentAmount() {
        return bag.currentAmount();
    }
}
