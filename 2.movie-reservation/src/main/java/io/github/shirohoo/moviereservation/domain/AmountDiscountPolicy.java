package io.github.shirohoo.moviereservation.domain;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private final Money discountAmount;

    private AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    public static AmountDiscountPolicy of(Money discountAmount, DiscountCondition... conditions) {
        return new AmountDiscountPolicy(discountAmount, conditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
