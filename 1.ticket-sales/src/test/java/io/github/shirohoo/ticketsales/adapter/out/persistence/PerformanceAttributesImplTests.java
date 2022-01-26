package io.github.shirohoo.ticketsales.adapter.out.persistence;

import io.github.shirohoo.ticketsales.domain.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.github.shirohoo.ticketsales.fixture.DomainFixture.audiences;
import static io.github.shirohoo.ticketsales.fixture.DomainFixture.ticketOfficeComedy;
import static org.assertj.core.api.Assertions.assertThat;

class PerformanceAttributesImplTests {
    PerformanceAttributesImpl attributes;

    @BeforeEach
    void setUp() throws Exception {
        attributes = new PerformanceAttributesImpl(ticketOfficeComedy(), audiences());
    }

    @Test
    void getAudiences() throws Exception {
        assertThat(attributes.getAudiences()).isNotNull();
    }

    @Test
    void getGenre() throws Exception {
        assertThat(attributes.getGenre()).isEqualTo(Genre.COMEDY);
    }

    @Test
    void getProfit() throws Exception {
        assertThat(attributes.getProfit()).isEqualTo(0L);
    }
}
