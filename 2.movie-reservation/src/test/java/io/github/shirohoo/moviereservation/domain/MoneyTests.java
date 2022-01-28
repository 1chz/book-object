package io.github.shirohoo.moviereservation.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class MoneyTests {
    @Test
    void wonLong() throws Exception {
        assertThatCode(() -> {
            Money.won(0);
        }).doesNotThrowAnyException();
    }

    @Test
    void wonLongException() throws Exception {
        assertThatThrownBy(() -> {
            Money.won(-1);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void wonDouble() throws Exception {
        assertThatCode(() -> {
            Money.won(0.0);
        }).doesNotThrowAnyException();
    }

    @Test
    void wonDoubleException() throws Exception {
        assertThatThrownBy(() -> {
            Money.won(-1.0);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void wonBigDecimal() throws Exception {
        assertThatCode(() -> {
            Money.won(BigDecimal.ZERO);
        }).doesNotThrowAnyException();
    }

    @Test
    void wonBigDecimalException() throws Exception {
        assertThatThrownBy(() -> {
            Money.won(BigDecimal.ONE.negate());
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void plus() throws Exception {
        Money money1 = Money.won(1);
        Money money2 = Money.won(1);
        assertThat(money1.plus(money2)).isEqualTo(Money.won(2));
    }

    @Test
    void minus() throws Exception {
        Money money1 = Money.won(1);
        Money money2 = Money.won(1);
        assertThat(money1.minus(money2)).isEqualTo(Money.won(0));
    }

    @Test
    void minusException() throws Exception {
        Money money1 = Money.won(1);
        Money money2 = Money.won(2);
        assertThatThrownBy(() -> {
            money1.minus(money2);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void audienceCountTimes() throws Exception {
        Money money = Money.won(10);
        assertThat(money.times(5)).isEqualTo(Money.won(50));
    }

    @Test
    void percentTimes() throws Exception {
        Money money = Money.won(100);
        assertThat(money.times(10.0)).isEqualTo(Money.won(10.0));
    }

    @Test
    void isLessThan() throws Exception {
        Money money1 = Money.won(1);
        Money money2 = Money.won(2);
        assertThat(money1.isLessThan(money2)).isTrue();

        Money money3 = Money.won(2);
        Money money4 = Money.won(1);
        assertThat(money3.isLessThan(money4)).isFalse();
    }

    @Test
    void isGraterThanOrEqual() throws Exception {
        Money money1 = Money.won(1);
        Money money2 = Money.won(2);
        assertThat(money1.isGraterThanOrEqual(money2)).isFalse();

        Money money3 = Money.won(2);
        Money money4 = Money.won(1);
        assertThat(money3.isGraterThanOrEqual(money4)).isTrue();
    }

    @Test
    void testEquals() throws Exception {
        Money money1 = Money.won(1);
        Money money2 = Money.won(2);
        assertThat(money1.equals(money2)).isFalse();
        assertThat(money1.equals(null)).isFalse();
        assertThat(money1.equals("string class")).isFalse();

        Money money3 = Money.won(1);
        Money money4 = Money.won(1);
        assertThat(money3.equals(money4)).isTrue();
    }

    @Test
    void testHashCode() throws Exception {
        Money money = Money.won(1);
        assertThat(money.hashCode()).isEqualTo(62);
    }
}