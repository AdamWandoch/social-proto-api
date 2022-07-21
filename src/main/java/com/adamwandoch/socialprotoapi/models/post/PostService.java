package com.adamwandoch.socialprotoapi.models.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Adam Wandoch
 */

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostModel> getAllPosts() {
        ArrayList<PostModel> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return posts
                .stream()
                .sorted(Comparator.comparing(PostModel::getId).reversed())
                .collect(Collectors.toList());
    }

    public Optional<PostModel> getPost(Long id) {
        return postRepository.findById(id);
    }

    public void savePost(PostModel post) {
        postRepository.save(post);
    }

    public void addLike(Long postId) {
        Optional<PostModel> post = postRepository.findById(postId);
        if (post.isPresent()) {
            PostModel updatedPost = post.get();
            updatedPost.setLikes(updatedPost.getLikes() + 1);
            postRepository.save(updatedPost);
        }
    }
}
