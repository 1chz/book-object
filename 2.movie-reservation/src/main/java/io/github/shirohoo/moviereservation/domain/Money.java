package io.github.shirohoo.moviereservation.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    public static final Money ZERO = Money.won(0);

    private final BigDecimal amount;

    private Money(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException();
        }

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

    public Money times(int audienceCount) {
        return Money.won(this.amount.multiply(BigDecimal.valueOf(audienceCount)));
    }

    public Money times(double percent) {
        BigDecimal salesPercentage = BigDecimal.valueOf(percent).divide(BigDecimal.valueOf(100));
        BigDecimal salesAmount = this.amount.multiply(salesPercentage);
        return Money.won(salesAmount);
    }

    public boolean isLessThan(Money money) {
        return amount.compareTo(money.amount) < 0;
    }

    public boolean isGraterThanOrEqual(Money money) {
        return amount.compareTo(money.amount) >= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
