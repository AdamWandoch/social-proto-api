package com.adamwandoch.socialprotoapi.controllers;

import com.adamwandoch.socialprotoapi.models.like.LikeService;
import org.junit.jupiter.api.BeforeEach;
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
class LikeControllerTest {

    @Mock
    private LikeService likeService;
    private LikeController underTest;

    @BeforeEach
    void setUp() {
        underTest = new LikeController(likeService);
    }

    @Test
    void canSaveLike() {
        // when
        underTest.saveLike(any());

        // then
        verify(likeService).saveLike(any());
    }

    @Test
    void canGetLikes() {
        // when
        underTest.getLikes(any());

        // then
        verify(likeService).getPostLikes(any());
    }

    @Test
    void canCheckIfUserAlreadyLiked() {
        // when
        underTest.userAlreadyLiked(any());

        // then
        verify(likeService).userAlreadyLiked(any());
    }
}