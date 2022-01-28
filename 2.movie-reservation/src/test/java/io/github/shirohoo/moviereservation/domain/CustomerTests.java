package io.github.shirohoo.moviereservation.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

class CustomerTests {
    @Test
    void newCustomer() {
        assertThatCode(() -> {
            Customer.newCustomer("name");
        }).doesNotThrowAnyException();
    }

    @Test
    void newCustomerException() {
        assertThatThrownBy(() -> {
            Customer.newCustomer(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    void of() {
        assertThatCode(() -> {
            Customer.of(null, "name");
        }).doesNotThrowAnyException();
    }
}