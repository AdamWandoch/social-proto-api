package com.adamwandoch.socialprotoapi.models.comment;

import com.adamwandoch.socialprotoapi.models.post.PostModel;
import com.adamwandoch.socialprotoapi.models.post.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * @author Adam Wandoch
 */

@ExtendWith(MockitoExtension.class)
class CommentServiceTest {

    @Mock
    private CommentRepository commentRepository;
    @Mock
    private PostService postService;
    private CommentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CommentService(commentRepository, postService);
    }

    @Test
    void canSaveComment() {
        // given
        CommentModel commentModel = new CommentModel();
        given(postService.getPost(commentModel.getPostId()))
                .willReturn(Optional.of(new PostModel()));

        // when
        underTest.saveComment(commentModel);

        // then
        verify(commentRepository).save(commentModel);
        verify(postService).addComment(commentModel.getPostId());
    }

    @Test
    void canGetCommentsByPostId() {
        // given
        Long id = 123L;

        // when
        underTest.getCommentsByPostId(id);

        // then
        verify(commentRepository).getCommentsByPostId(id);
    }
}