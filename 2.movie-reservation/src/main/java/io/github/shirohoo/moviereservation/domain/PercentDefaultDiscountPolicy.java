package io.github.shirohoo.moviereservation.domain;

public class PercentDefaultDiscountPolicy extends DefaultDiscountPolicy {
    private final double percent;

    public PercentDefaultDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee()
            .times(percent);
    }
}
