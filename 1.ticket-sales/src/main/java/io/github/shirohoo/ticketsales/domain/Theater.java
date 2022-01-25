package io.github.shirohoo.ticketsales.domain;

public class Theater {
    private final TicketSeller ticketSeller;

    private Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public static Theater from(TicketSeller ticketSeller) {
        return new Theater(ticketSeller);
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
