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

    public String likePost(Long postId, Long userId) {
        Optional<PostModel> oldPost = postRepository.findById(postId);
        if (oldPost.isPresent()) {
            PostModel newPost = oldPost.get();
            if (!newPost.getUsersThatLiked().contains(userId)) {
                newPost.like(userId);
                postRepository.save(newPost);
                return "Post Liked";
            }
            return "Post already liked by this user";
        }
        return "Post not found";
    }

    public void savePost(PostModel post) {
        postRepository.save(post);
    }

    public Optional<PostModel> getPost(Long id) {
        return postRepository.findById(id);
    }
}
