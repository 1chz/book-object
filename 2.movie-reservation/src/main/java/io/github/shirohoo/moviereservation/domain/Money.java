package io.github.shirohoo.moviereservation.domain;

import java.math.BigDecimal;

public class Money {
    public static final Money ZERO = Money.won(0);

    private final BigDecimal amount;

    private Money(BigDecimal amount) {
        this.amount = amount;
    }

    public static Money won(BigDecimal amount) {
        return new Money(amount);
    }

    public static Money won(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money won(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public Money plus(Money money) {
        return Money.won(this.amount.add(money.amount));
    }

    public Money minus(Money money) {
        return Money.won(this.amount.subtract(money.amount));
    }

    public Money times(double percent) {
        BigDecimal percentBigDecimal = BigDecimal.valueOf(percent);
        return Money.won(this.amount.multiply(percentBigDecimal));
    }

    public boolean isLessThan(Money money) {
        return amount.compareTo(money.amount) < 0;
    }

    public boolean isGraterThanOrEqual(Money money) {
        return amount.compareTo(money.amount) >= 0;
    }
}
