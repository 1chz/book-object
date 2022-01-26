package io.github.shirohoo.ticketsales.adapter.out.persistence;

import io.github.shirohoo.ticketsales.domain.Audience;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Table(name = "audience")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AudienceEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PerformanceEntity performance;

    private AudienceEntity(Long id, PerformanceEntity performance) {
        this.id = id;
        this.performance = performance;
    }

    public static AudienceEntity of(Audience audience, PerformanceEntity performance) {
        return new AudienceEntity(audience.getId(), performance);
    }
}
