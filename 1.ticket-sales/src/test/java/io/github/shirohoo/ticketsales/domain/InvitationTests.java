package io.github.shirohoo.ticketsales.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class InvitationTests {
    @Test
    void createInvitation() {
        assertThatCode(() -> {
            Invitation.from(now());
        }).doesNotThrowAnyException();
    }

    @Test
    void when() throws Exception {
        Invitation invitation = Invitation.from(now());
        assertThat(invitation.when()).isNotNull();
        assertThat(invitation.when()).isInstanceOf(LocalDateTime.class);
    }
}
