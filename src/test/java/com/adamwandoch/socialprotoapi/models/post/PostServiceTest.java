package com.adamwandoch.socialprotoapi.models.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * @author Adam Wandoch
 */

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private PostRepository postRepository;
    private PostService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PostService(postRepository);
    }

    @Test
    void canGetAllPosts() {
        // when
        underTest.getAllPosts();
        // then
        verify(postRepository).findAll();
    }

    @Test
    void canGetPost() {
        // given
        Long id = 123L;

        // when
        underTest.getPost(id);

        // then
        verify(postRepository).findById(id);
    }

    @Test
    void canSavePost() {
        // given
        PostModel post = new PostModel();

        // when
        underTest.savePost(post);

        // then
        ArgumentCaptor<PostModel> postModelArgumentCaptor = ArgumentCaptor.forClass(PostModel.class);

        verify(postRepository).save(postModelArgumentCaptor.capture());

        PostModel capturedPost = postModelArgumentCaptor.getValue();
        assertThat(capturedPost).isEqualTo(post);
    }

    @Test
    void canAddLike() {
        // given
        PostModel post = new PostModel();

        given(postRepository.findById(any()))
                .willReturn(Optional.of(post));

        // when
        underTest.addLike(post.getId());

        // then
        verify(postRepository).save(post);
    }

    @Test
    void canAddComment() {
        // given
        PostModel post = new PostModel();

        given(postRepository.findById(any()))
                .willReturn(Optional.of(post));

        // when
        underTest.addComment(post.getId());

        // then
        verify(postRepository).save(post);
    }
}