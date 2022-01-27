package io.github.shirohoo.moviereservation.domain;

public class SequenceDiscountCondition implements DiscountCondition {
    private final int sequence;

    private SequenceDiscountCondition(int sequence) {
        this.sequence = sequence;
    }

    public static SequenceDiscountCondition from(int sequence) {
        return new SequenceDiscountCondition(sequence);
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
