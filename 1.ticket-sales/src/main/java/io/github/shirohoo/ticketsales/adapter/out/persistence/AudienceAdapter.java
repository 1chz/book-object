package io.github.shirohoo.ticketsales.adapter.out.persistence;

import io.github.shirohoo.ticketsales.domain.Audience;
import io.github.shirohoo.ticketsales.port.out.SaveAudience;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AudienceAdapter implements SaveAudience {
    private final AudienceMapper audienceMapper;
    private final AudienceJpaRepository jpaRepository;

    @Override
    public Audience save(Audience audience) {
        AudienceEntity entity = audienceMapper.toEntity(audience);
        AudienceEntity savedEntity = jpaRepository.save(entity);
        return audienceMapper.toDomain(savedEntity);
    }
}
