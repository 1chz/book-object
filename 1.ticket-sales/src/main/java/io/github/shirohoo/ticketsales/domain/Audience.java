package io.github.shirohoo.ticketsales.domain;

public class Audience {
    private final Long id;
    private final Bag bag;

    public Audience(Long id, Bag bag) {
        this.id = id;
        this.bag = bag;
    }

    public static Audience of(Long id, Bag bag) {
        return new Audience(id, bag);
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

    public Long getId() {
        return id;
    }
}
