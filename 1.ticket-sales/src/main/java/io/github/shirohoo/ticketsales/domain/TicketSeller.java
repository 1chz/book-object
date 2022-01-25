package io.github.shirohoo.ticketsales.domain;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    private TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public static TicketSeller from(TicketOffice ticketOffice) {
        return new TicketSeller(ticketOffice);
    }

    public void sellTo(Audience audience) {
        ticketOffice.plusAmount(audience.buy(getTicket()));
    }

    private Ticket getTicket() {
        return ticketOffice.getTicket();
    }
}
