package com.adamwandoch.socialprotoapi.models.like;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Adam Wandoch
 */

class LikeModelTest {

    private LikeModel underTest;

    @Test
    void canGetId() {
        // given
        underTest = new LikeModel();
        // when
        Long actual = underTest.getId();
        // then
        assertThat(actual).isNull();
    }
}