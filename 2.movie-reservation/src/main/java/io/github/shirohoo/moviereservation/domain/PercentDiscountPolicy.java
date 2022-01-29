package io.github.shirohoo.moviereservation.domain;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private final double percent;

    private PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    public static PercentDiscountPolicy of(double percent, DiscountCondition... conditions) {
        return new PercentDiscountPolicy(percent, conditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee()
            .times(percent);
    }
}
