package io.github.shirohoo.moviereservation.domain;

public class AmountDefaultDiscountPolicy extends DefaultDiscountPolicy {
    private final Money discountAmount;

    private AmountDefaultDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    public static AmountDefaultDiscountPolicy of(Money discountAmount, DiscountCondition... conditions) {
        return new AmountDefaultDiscountPolicy(discountAmount, conditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
