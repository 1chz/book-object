package io.github.shirohoo.ticketsales.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class BagTests {
    @Test
    void from() {
        assertThatCode(() -> {
            Bag.from(10_000L);
        }).doesNotThrowAnyException();
    }

    @Test
    void of() {
        assertThatCode(() -> {
            Bag.of(Invitation.from(now()), 10_000L);
        }).doesNotThrowAnyException();
    }

    @MethodSource
    @ParameterizedTest
    void hasInvitation(Bag bag, boolean expected) {
        assertThat(bag.hasInvitation()).isEqualTo(expected);
    }

    static Stream<Arguments> hasInvitation() {
        return Stream.of(
                Arguments.of(Bag.of(Invitation.from(now()), 10_000L), true),
                Arguments.of(Bag.from(10_000L), false)
        );
    }

    @Test
    void hasTicket() throws Exception {
        Bag bag = Bag.from(10_000L);
        assertThat(bag.hasTicket()).isFalse();
    }
}
