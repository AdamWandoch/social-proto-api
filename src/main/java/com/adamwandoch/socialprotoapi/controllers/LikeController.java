package com.adamwandoch.socialprotoapi.controllers;

import com.adamwandoch.socialprotoapi.models.like.LikeModel;
import com.adamwandoch.socialprotoapi.models.like.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Adam Wandoch
 */
@RestController
@CrossOrigin(origins = {"https://social-app-prototype.netlify.app/", "http://localhost:3000", "https://localhost:44347/"})
public class LikeController {

    @Autowired
    private LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/like/save")
    public String saveLike(@RequestBody LikeModel like) {
        return likeService.saveLike(like);
    }

    @GetMapping("/like/get/{postId}")
    public int getLikes(@PathVariable(value = "postId") Long postId) {
        return likeService.getPostLikes(postId).size();
    }

    @PostMapping("/like/user-liked")
    public boolean userAlreadyLiked(@RequestBody LikeModel like) {
        return likeService.userAlreadyLiked(like);
    }
}
