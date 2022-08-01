package com.adamwandoch.socialprotoapi.controllers.websocket;

import com.adamwandoch.socialprotoapi.models.post.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

/**
 * @author Adam Wandoch
 */

@ExtendWith(MockitoExtension.class)
class FeedControllerTest {

    @Mock
    private PostService postService;
    private FeedController underTest;

    @BeforeEach
    void setUp() {
        underTest = new FeedController(postService);
    }

    @Test
    void canReceiveMessage() throws InterruptedException {
        // when
        underTest.receiveMessage("any string");

        // then
        verify(postService).getAllPosts();
    }
}