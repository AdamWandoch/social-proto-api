package com.adamwandoch.socialprotoapi.models.comment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Adam Wandoch
 */

class CommentModelTest {

    private CommentModel underTest;

    @BeforeEach
    void setUp() {
        underTest = new CommentModel();
    }

    @Test
    void canGetId() {
        // when
        Long actual = underTest.getId();

        // then
        assertThat(actual).isNull();
    }

    @Test
    void canUserGetId() {
        // when
        Long actual = underTest.getUserId();

        // then
        assertThat(actual).isNull();
    }

    @Test
    void canGetUserId() {
        // when
        Long actual = underTest.getPostId();

        // then
        assertThat(actual).isNull();
    }

    @Test
    void canGetContent() {
        // when
        String actual = underTest.getContent();

        // then
        assertThat(actual).isNull();
    }

    @Test
    void canGetTimestamp() {
        // when
        String actual = underTest.getTimestamp();

        // then
        assertThat(actual).isNull();
    }
}