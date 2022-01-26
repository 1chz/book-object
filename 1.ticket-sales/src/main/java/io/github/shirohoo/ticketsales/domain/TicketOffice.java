package io.github.shirohoo.ticketsales.domain;

import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class TicketOffice {
    private final Genre genre;
    private final AtomicLong amount;
    private final Queue<Ticket> tickets = new LinkedBlockingQueue<>();

    private TicketOffice(Genre genre, long amount, Ticket... tickets) {
        this.genre = genre;
        this.amount = new AtomicLong(amount);
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public static TicketOffice of(Genre genre, long amount, Ticket... tickets) {
        return new TicketOffice(genre, amount, tickets);
    }

    public Ticket getTicket() {
        if (tickets.size() > 0) {
            return tickets.poll();
        }
        throw new IllegalStateException();
    }

    public void plusAmount(long amount) {
        long balance = this.amount.get();
        this.amount.set(balance + amount);
    }

    public long currentAmount() {
        return amount.get();
    }

    public Genre getGenre() {
        return genre;
    }
}
