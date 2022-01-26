package io.github.shirohoo.ticketsales.adapter.out.persistence;

import io.github.shirohoo.ticketsales.domain.Genre;
import org.junit.jupiter.api.Test;

import static io.github.shirohoo.ticketsales.fixture.DomainFixture.performanceAttributes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class PerformanceEntityTests {
    @Test
    void from() throws Exception {
        assertThatCode(() -> {
            PerformanceEntity.from(performanceAttributes());
        }).doesNotThrowAnyException();
    }

    @Test
    void getId() throws Exception {
        PerformanceEntity performance = PerformanceEntity.from(performanceAttributes());
        assertThat(performance.getId()).isNull();
    }

    @Test
    void getGenre() throws Exception {
        PerformanceEntity performance = PerformanceEntity.from(performanceAttributes());
        assertThat(performance.getGenre()).isEqualTo(Genre.COMEDY);
    }

    @Test
    void getProfit() throws Exception {
        PerformanceEntity performance = PerformanceEntity.from(performanceAttributes());
        assertThat(performance.getProfit()).isEqualTo(50_000L);
    }
}
