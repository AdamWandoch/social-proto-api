package com.adamwandoch.socialprotoapi.controllers;

import com.adamwandoch.socialprotoapi.models.post.PostModel;
import com.adamwandoch.socialprotoapi.models.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Adam Wandoch
 */

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/post/post")
    public ResponseEntity postPost(@RequestBody PostModel post) {
        postService.savePost(post);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/post/getall")
    public ArrayList<PostModel> getAllPosts() {
        return (ArrayList<PostModel>) postService.getAll()
                .stream()
                .sorted(Comparator.comparing(PostModel::getId).reversed())
                .collect(Collectors.toList());
    }

    @GetMapping("/post/{id}")
    public Optional<PostModel> getPost(@PathVariable(value = "id") Long id) {
        return postService.getPost(id);
    }
}
