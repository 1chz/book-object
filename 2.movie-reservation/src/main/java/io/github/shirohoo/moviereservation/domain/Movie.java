package io.github.shirohoo.moviereservation.domain;

import java.time.Duration;

public class Movie {
    private final String title;
    private final Duration runningTime;
    private final Money fee;
    private DiscountPolicy discountPolicy;

    private Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public static Movie of(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        return new Movie(title, runningTime, fee, discountPolicy);
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        Money discountAmount = discountPolicy.calculateDiscountAmount(screening);
        return fee.minus(discountAmount);
    }

    public void setDiscountPolicy(DefaultDiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
