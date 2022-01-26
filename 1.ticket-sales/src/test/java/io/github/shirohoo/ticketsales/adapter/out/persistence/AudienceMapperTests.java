package io.github.shirohoo.ticketsales.adapter.out.persistence;

import io.github.shirohoo.ticketsales.domain.Audience;
import io.github.shirohoo.ticketsales.domain.Bag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AudienceMapperTests {
    AudienceMapper mapper;
    Audience domain;
    AudienceEntity entity;

    @BeforeEach
    void setUp() throws Exception {
        mapper = new AudienceMapper();
        domain = Audience.of(1L, Bag.from(10_000L));
        entity = AudienceEntity.from(domain);
    }

    @Test
    void toDomain() throws Exception {
        Audience audience = mapper.toDomain(entity);
        assertThat(audience.getId()).isEqualTo(entity.getId());
        assertThat(audience.currentAmount()).isEqualTo(entity.getAmount());
        assertThat(audience.hasTicket()).isEqualTo(entity.isHasTicket());
    }

    @Test
    void toEntity() throws Exception {
        AudienceEntity audienceEntity = mapper.toEntity(domain);
        assertThat(audienceEntity.getId()).isEqualTo(domain.getId());
        assertThat(audienceEntity.getAmount()).isEqualTo(domain.currentAmount());
        assertThat(audienceEntity.isHasTicket()).isEqualTo(domain.hasTicket());
    }
}
