package com.adamwandoch.socialprotoapi.controllers;

import com.adamwandoch.socialprotoapi.models.comment.CommentRepository;
import com.adamwandoch.socialprotoapi.models.like.LikeRepository;
import com.adamwandoch.socialprotoapi.models.post.PostRepository;
import com.adamwandoch.socialprotoapi.models.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam Wandoch
 */

@RestController
@CrossOrigin
public class CleanupController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private CommentRepository commentRepository;

    public CleanupController(UserRepository userRepository, PostRepository postRepository, LikeRepository likeRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping("/clear")
    public String wipeClean() {
        String message = "WIPEOUT COMPLETE";
        userRepository.deleteAll();
        postRepository.deleteAll();
        likeRepository.deleteAll();
        commentRepository.deleteAll();
        return message;
    }
}
