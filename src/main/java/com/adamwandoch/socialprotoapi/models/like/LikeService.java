package com.adamwandoch.socialprotoapi.models.like;

import com.adamwandoch.socialprotoapi.models.post.PostModel;
import com.adamwandoch.socialprotoapi.models.post.PostService;
import com.adamwandoch.socialprotoapi.models.user.UserModel;
import com.adamwandoch.socialprotoapi.models.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Adam Wandoch
 */

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    public List<LikeModel> getPostLikes(Long postId) {
        ArrayList<LikeModel> likes = new ArrayList<>();
        likeRepository.findAll().forEach(likes::add);
        return likes.stream()
                .filter(like -> Objects.equals(like.getPostId(), postId))
                .collect(Collectors.toList());
    }

    public String saveLike(LikeModel like) {
        Optional<PostModel> post = postService.getPost(like.getPostId());
        Optional<UserModel> user = userService.getUser(like.getUserId());

        if (post.isPresent() && user.isPresent()) {
            List<LikeModel> likes = getPostLikes(like.getPostId());
            if (likes != null) {
                if (likes.stream()
                        .noneMatch(l -> Objects.equals(l.getUserId(), like.getUserId()))) {
                    likeRepository.save(like);
                    return "Post liked.";
                } else return "Post already liked by this user.";
            }
        }
        return "Post or user not found.";
    }

    public boolean userAlreadyLiked(LikeModel like) {
        List<LikeModel> likes = getPostLikes(like.getPostId());
        if (likes.size() > 0) {
            return likes.stream()
                    .anyMatch(l -> Objects.equals(l.getUserId(), like.getUserId()));
        } else return false;
    }
}
