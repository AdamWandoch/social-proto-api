package com.adamwandoch.socialprotoapi.models.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Adam Wandoch
 */

class PostModelTest {

   private PostModel underTest;

   @BeforeEach
   void setUp() {
      underTest = new PostModel();
   }

   @Test
    void CanGetUserId() {
      assertThat(underTest.getUserId()).isNull();
    }

    @Test
    void canGetContent() {
      assertThat(underTest.getContent()).isNull();
    }

    @Test
    void canGetTimestamp() {
      assertThat(underTest.getTimestamp()).isNull();
    }
}