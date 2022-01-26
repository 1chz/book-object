package io.github.shirohoo.ticketsales.adapter.out.persistence;

import io.github.shirohoo.ticketsales.domain.Audience;
import io.github.shirohoo.ticketsales.domain.Bag;
import org.springframework.stereotype.Component;

@Component
public class AudienceMapper {
    public Audience toDomain(AudienceEntity entity) {
        Bag bag = Bag.from(entity.getAmount());
        return Audience.of(entity.getId(), bag);
    }

    public AudienceEntity toEntity(Audience audience) {
        return AudienceEntity.from(audience);
    }
}
