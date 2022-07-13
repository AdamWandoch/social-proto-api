package com.adamwandoch.socialprotoapi.models.like;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Adam Wandoch
 */

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public List<LikeModel> getPostLikes(Long postId) {
        ArrayList<LikeModel> likes = new ArrayList<>();
        likeRepository.findAll().forEach(likes::add);
        return likes.stream()
                .filter(like -> Objects.equals(like.getPostId(), postId))
                .collect(Collectors.toList());
    }

    public String saveLike(LikeModel like) {
        List<LikeModel> likes = getPostLikes(like.getPostId());

        // FIXME: 13/07/2022 prevent un-existing posts from being liked and un-existing users from liking
        if (likes != null) {
            if (likes.stream()
                    .noneMatch(l -> Objects.equals(l.getUserId(), like.getUserId()))) {
                likeRepository.save(like);
                return "Post liked.";
            } else return "Post already liked by this user.";
        }
        return "Post not found.";
    }

    public boolean userAlreadyLiked(LikeModel like) {
        List<LikeModel> likes = getPostLikes(like.getPostId());
        if (likes.size() > 0) {
            return likes.stream()
                    .anyMatch(l -> Objects.equals(l.getUserId(), like.getUserId()));
        } else return false;
    }
}
