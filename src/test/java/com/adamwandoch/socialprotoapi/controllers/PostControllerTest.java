package com.adamwandoch.socialprotoapi.controllers;

import com.adamwandoch.socialprotoapi.models.post.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * @author Adam Wandoch
 */

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @Mock
    private PostService postService;
    private PostController underTest;

    @BeforeEach
    void setUp() {
        underTest = new PostController(postService);
    }

    @Test
    void canPostPost() {
        // when
        underTest.postPost(any());

        // then
        verify(postService).savePost(any());
    }

    @Test
    @Disabled
    void canGetAllPosts() {
        // when
        underTest.getAllPosts();

        // then
        verify(postService).getAllPosts();
    }

    @Test
    void canGetPost() {
        // when
        underTest.getPost(any());

        // then
        verify(postService).getPost(any());
    }
}