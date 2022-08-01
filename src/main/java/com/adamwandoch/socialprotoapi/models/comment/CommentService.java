package com.adamwandoch.socialprotoapi.models.comment;

import com.adamwandoch.socialprotoapi.models.post.PostModel;
import com.adamwandoch.socialprotoapi.models.post.PostService;
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

    public CommentService(CommentRepository commentRepository,
                          PostService postService) {
        this.commentRepository = commentRepository;
        this.postService = postService;
    }

    public void saveComment(CommentModel commentModel) {
        Optional<PostModel> post = postService.getPost(commentModel.getPostId());
        if (post.isPresent()) {
            commentRepository.save(commentModel);
            postService.addComment(commentModel.getPostId());
        }
    }

    public ArrayList<CommentModel> getCommentsByPostId(Long postId) {
            return commentRepository.getCommentsByPostId(postId);
    }
}
