package io.github.shirohoo.ticketsales.adapter.out.persistence;

import io.github.shirohoo.ticketsales.domain.Audience;
import io.github.shirohoo.ticketsales.domain.Bag;
import org.junit.jupiter.api.Test;

import static io.github.shirohoo.ticketsales.fixture.DomainFixture.performanceAttributes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class AudienceEntityTests {
    @Test
    void of() throws Exception {
        Audience audience = Audience.of(null, Bag.from(10_000L));
        PerformanceEntity performance = PerformanceEntity.from(performanceAttributes());
        assertThatCode(() -> {
            AudienceEntity.of(audience, performance);
        }).doesNotThrowAnyException();
    }

    @Test
    void getId() throws Exception {
        Audience audience = Audience.of(null, Bag.from(10_000L));
        PerformanceEntity performance = PerformanceEntity.from(performanceAttributes());
        AudienceEntity audienceEntity = AudienceEntity.of(audience, performance);
        assertThat(audienceEntity.getId()).isNull();
    }

    @Test
    void getPerformance() throws Exception {
        Audience audience = Audience.of(null, Bag.from(10_000L));
        PerformanceEntity performance = PerformanceEntity.from(performanceAttributes());
        AudienceEntity audienceEntity = AudienceEntity.of(audience, performance);
        assertThat(audienceEntity.getPerformance()).isEqualTo(performance);
    }
}
