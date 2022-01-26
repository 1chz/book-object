package io.github.shirohoo.ticketsales.adapter.out.persistence;

import io.github.shirohoo.ticketsales.port.out.PerformanceAttributes;
import io.github.shirohoo.ticketsales.port.out.SavePerformanceInformation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AudienceAdapter implements SavePerformanceInformation {
    private final AudienceJpaRepository audienceJpaRepository;
    private final PerformanceJpaRepository performanceJpaRepository;

    @Override
    @Transactional
    public boolean save(PerformanceAttributes attributes) {
        try {
            if (attributes == null) {
                throw new IllegalArgumentException();
            }

            PerformanceEntity performance = PerformanceEntity.from(attributes);
            performanceJpaRepository.save(performance);
            audienceJpaRepository.saveAll(attributes.getAudiences()
                    .stream()
                    .map(audience -> AudienceEntity.of(audience, performance))
                    .collect(Collectors.toSet()));

            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
