package io.github.shirohoo.ticketsales.domain;

public class Bag {
    private long amount;
    private final Invitation invitation;
    private Ticket ticket;

    private Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public static Bag from(long amount) {
        return new Bag(null, amount);
    }

    public static Bag of(Invitation invitation, long amount) {
        return new Bag(invitation, amount);
    }

    public long hold(Ticket ticket){
        if(hasInvitation()) {
            setTicket(ticket);
            return 0L;
        }
        setTicket(ticket);
        minusAmount(ticket.getFee());
        return ticket.getFee();
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(long amount) {
        this.amount -= amount;
    }

    public long currentAmount() {
        return amount;
    }
}
