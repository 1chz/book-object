package io.github.shirohoo.moviereservation.domain;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
