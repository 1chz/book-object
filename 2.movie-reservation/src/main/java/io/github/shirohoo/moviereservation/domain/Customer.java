package io.github.shirohoo.moviereservation.domain;

import java.util.Objects;

public class Customer {
    private final Long id;
    private final String name;

    private Customer(Long id, String name) {
        this.id = id;
        this.name = Objects.requireNonNull(name);
    }

    public static Customer newCustomer(String name) {
        return new Customer(null, name);
    }

    public static Customer of(Long id, String name) {
        return new Customer(id, name);
    }
}
