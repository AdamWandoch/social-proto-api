package com.adamwandoch.socialprotoapi.controllers;

import com.adamwandoch.socialprotoapi.models.comment.CommentRepository;
import com.adamwandoch.socialprotoapi.models.like.LikeRepository;
import com.adamwandoch.socialprotoapi.models.post.PostRepository;
import com.adamwandoch.socialprotoapi.models.user.UserRepository;
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
class CleanupControllerTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private PostRepository postRepository;
    @Mock
    private LikeRepository likeRepository;
    @Mock
    private CommentRepository commentRepository;

    private CleanupController underTest;

    @BeforeEach
    void setUp() {
        underTest = new CleanupController(userRepository,
                postRepository,
                likeRepository,
                commentRepository);
    }

    @Test
    void canWipeClean() {
        // when
        underTest.wipeClean();

        // then
        verify(userRepository).deleteAll();
        verify(postRepository).deleteAll();
        verify(likeRepository).deleteAll();
        verify(commentRepository).deleteAll();
    }
}