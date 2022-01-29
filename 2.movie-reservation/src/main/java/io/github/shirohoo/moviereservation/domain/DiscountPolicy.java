package io.github.shirohoo.moviereservation.domain;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
