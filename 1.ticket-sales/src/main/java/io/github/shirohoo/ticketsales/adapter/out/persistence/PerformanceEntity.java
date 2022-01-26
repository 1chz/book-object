package io.github.shirohoo.ticketsales.adapter.out.persistence;

import io.github.shirohoo.ticketsales.domain.Genre;
import io.github.shirohoo.ticketsales.port.out.PerformanceAttributes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Table(name = "performance_information")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PerformanceEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private long profit;

    private PerformanceEntity(Long id, Genre genre, long profit) {
        this.id = id;
        this.genre = genre;
        this.profit = profit;
    }

    public static PerformanceEntity from(PerformanceAttributes attributes) {
        return new PerformanceEntity(null, attributes.getGenre(), attributes.getProfit());
    }
}
