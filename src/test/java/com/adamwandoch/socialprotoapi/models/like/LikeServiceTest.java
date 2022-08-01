package com.adamwandoch.socialprotoapi.models.like;

import com.adamwandoch.socialprotoapi.models.post.PostModel;
import com.adamwandoch.socialprotoapi.models.post.PostService;
import com.adamwandoch.socialprotoapi.models.user.UserModel;
import com.adamwandoch.socialprotoapi.models.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * @author Adam Wandoch
 */

@ExtendWith(MockitoExtension.class)
class LikeServiceTest {

    @Mock
    private LikeRepository likeRepository;
    @Mock
    private PostService postService;
    @Mock
    private UserService userService;
    private LikeService underTest;

    @BeforeEach
    void setUp() {
        this.underTest = new LikeService(likeRepository, postService, userService);
    }

    @Test
    void canGetPostLikes() {
        // when
        underTest.getPostLikes(123L);

        // then
        verify(likeRepository).findAll();
    }

    @Test
    void canSaveLike() {
        // given
        LikeModel likeModel = new LikeModel();
        given(postService.getPost(likeModel.getPostId()))
                .willReturn(Optional.of(new PostModel()));
        given(userService.getUser(likeModel.getUserId()))
                .willReturn(Optional.of(new UserModel()));

        // when
        underTest.saveLike(likeModel);

        // then
        verify(likeRepository).save(likeModel);
        verify(postService).addLike(likeModel.getPostId());
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void willNotSaveLikeWhenPostAlreadyLikedByUser() {
        // given
        LikeModel likeModel = new LikeModel();

        List<LikeModel> likeModels = List.of(likeModel);

        given(underTest.getPostLikes(likeModel.getPostId()))
                .willReturn(likeModels);
        given(postService.getPost(likeModel.getPostId()))
                .willReturn(Optional.of(new PostModel()));
        given(userService.getUser(likeModel.getUserId()))
                .willReturn(Optional.of(new UserModel()));

        // when
        String actual = underTest.saveLike(likeModel);

        // then
        assertThat(actual).isEqualTo("Post already liked by this user.");
    }


    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void willNotSaveLikeWhenPostOrUserNotFound() {
        // given
        LikeModel likeModel = new LikeModel();

        given(underTest.getPostLikes(likeModel.getPostId()))
                .willReturn(null);

        // when
        String actual = underTest.saveLike(likeModel);

        // then
        String expected = "Post or user not found.";
        assertThat(actual).isEqualTo(expected);
        verify(likeRepository, never()).save(likeModel);
        verify(postService, never()).addLike(likeModel.getPostId());
    }

    @Test
    void canCheckIfUserAlreadyLiked() {
        // given
        Long id = 123L;
        LikeModel likeModel = new LikeModel();
        likeModel.setId(id);
        List<LikeModel> likeModels = List.of(likeModel);
        given(underTest.getPostLikes(id))
                .willReturn(likeModels);
        // when
        boolean actual = underTest.userAlreadyLiked(likeModel);

        // then
        assertThat(actual).isEqualTo(true);
    }

    @Test
    void canCheckIfUserDidntLikeYet() {
        // given
        Long id = 123L;
        LikeModel likeModel = new LikeModel();
        likeModel.setId(id);
        given(underTest.getPostLikes(id))
                .willReturn(new ArrayList<LikeModel>());
        // when
        boolean actual = underTest.userAlreadyLiked(likeModel);

        // then
        assertThat(actual).isEqualTo(false);
    }
}
