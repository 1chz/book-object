package io.github.shirohoo.ticketsales.adapter.out.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.github.shirohoo.ticketsales.fixture.DomainFixture.performanceAttributes;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AudienceAdapterTests {
    @Autowired
    AudienceAdapter audienceAdapter;

    @Test
    void save() throws Exception {
        boolean result = audienceAdapter.save(performanceAttributes());
        assertThat(result).isTrue();
    }

    @Test
    void saveException() throws Exception {
        boolean result = audienceAdapter.save(null);
        assertThat(result).isFalse();
    }
}
