package com.adamwandoch.socialprotoapi.controllers;

import com.adamwandoch.socialprotoapi.models.comment.CommentService;
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
class CommentControllerTest {

    @Mock
    private CommentService commentService;
    private CommentController underTest;

    @BeforeEach
    void setUp() {
        underTest = new CommentController(commentService);
    }

    @Test
    void canSaveComment() {
        // when
        underTest.saveComment(any());

        // then
        verify(commentService).saveComment(any());
    }

    @Test
    void canGetComments() {
        // when
        underTest.getComments(any());

        // then
        verify(commentService).getCommentsByPostId(any());
    }
}