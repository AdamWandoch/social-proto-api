package com.adamwandoch.socialprotoapi.models.comment;

import com.adamwandoch.socialprotoapi.models.post.PostModel;
import com.adamwandoch.socialprotoapi.models.post.PostService;
import com.adamwandoch.socialprotoapi.models.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Adam Wandoch
 */

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    public void saveComment(CommentModel commentModel) {
        commentRepository.save(commentModel);
    }

    public ArrayList<CommentModel> getCommentsByPostId(Long postId) {
        Optional<PostModel> post = postService.getPost(postId);
        if (post.isPresent()) {
            return commentRepository.getCommentsByPostId(postId);
        }
        return null;
    }
}
