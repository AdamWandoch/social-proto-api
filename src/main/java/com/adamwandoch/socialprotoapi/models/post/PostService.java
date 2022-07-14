package com.adamwandoch.socialprotoapi.models.post;

import com.adamwandoch.socialprotoapi.models.user.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

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

//    public String likePost(Long postId, Long userId) {
//        Optional<PostModel> oldPost = postRepository.findById(postId);
//        Optional<UserModel> user = userRepository.findById(userId);
//        if (oldPost.isPresent() && user.isPresent()) {
//            PostModel newPost = oldPost.get();
//            if (!newPost.getUsersThatLiked().contains(userId)) {
//                newPost.like(userId);
//                postRepository.save(newPost);
//                return "Post Liked";
//            }
//            return "Post already liked by this user";
//        }
//        return "Post or user not found";
//    }
}
