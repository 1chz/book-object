package io.github.shirohoo.ticketsales.adapter.out.persistence;

import io.github.shirohoo.ticketsales.domain.Audience;
import io.github.shirohoo.ticketsales.domain.Bag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AudienceAdapterTests {
    @Autowired
    AudienceAdapter audienceAdapter;

    @Test
    void save() {
        // ...given
        Audience audience = Audience.of(null, Bag.from(10_000L));

        // ...when
        Audience savedAudience = audienceAdapter.save(audience);

        // ...then
        assertThat(savedAudience.getId()).isEqualTo(1L);
        assertThat(savedAudience.currentAmount()).isEqualTo(audience.currentAmount());
        assertThat(savedAudience.hasTicket()).isEqualTo(audience.hasTicket());
        assertThat(savedAudience.hasInvitation()).isFalse();
    }
}
