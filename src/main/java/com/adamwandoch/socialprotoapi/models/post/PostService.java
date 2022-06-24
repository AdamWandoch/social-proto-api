package com.adamwandoch.socialprotoapi.models.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Adam Wandoch
 */

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostService() {
    }

    public ArrayList<PostModel> getAll() {
        ArrayList<PostModel> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts;
    }

    public void savePost(PostModel post) {
        postRepository.save(post);
    }

    public Optional<PostModel> getPost(Long id) {
        return postRepository.findById(id);
    }
}
