package io.github.shirohoo.moviereservation.domain;

import java.time.LocalDateTime;

public class Screening {
    private final Movie movie;
    private final int sequence;
    private final LocalDateTime whenScreened;

    private Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public static Screening of(Movie movie, int sequence, LocalDateTime whenScreened) {
        return new Screening(movie, sequence, whenScreened);
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee(){
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return Reservation.of(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this)
            .times(audienceCount);
    }
}
