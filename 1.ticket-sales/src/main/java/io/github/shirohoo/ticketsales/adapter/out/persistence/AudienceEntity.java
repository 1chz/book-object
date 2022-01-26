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

    private long amount;

    private boolean hasTicket;

    private AudienceEntity(Long id, long amount, boolean hasTicket) {
        this.id = id;
        this.amount = amount;
        this.hasTicket = hasTicket;
    }

    public static AudienceEntity from(Audience audience) {
        return new AudienceEntity(audience.getId(), audience.currentAmount(), audience.hasTicket());
    }
}
