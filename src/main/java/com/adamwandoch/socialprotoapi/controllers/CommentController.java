package com.adamwandoch.socialprotoapi.controllers;

import com.adamwandoch.socialprotoapi.models.comment.CommentModel;
import com.adamwandoch.socialprotoapi.models.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Adam Wandoch
 */

@RestController
@CrossOrigin(origins = {"https://social-app-prototype.netlify.app/", "http://localhost:3000", "https://localhost:44347/"})
public class CommentController {

    @Autowired
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comment/save")
    public ResponseEntity saveComment(@RequestBody CommentModel comment) {
        commentService.saveComment(comment);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/comment/{postId}")
    public ArrayList<CommentModel> getComments(@PathVariable (value = "postId") Long postId) {
        return commentService.getCommentsByPostId(postId);
    }
}
