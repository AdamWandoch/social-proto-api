package com.adamwandoch.socialprotoapi.models.comment;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * @author Adam Wandoch
 */

public interface CommentRepository extends CrudRepository<CommentModel, Long> {
    ArrayList<CommentModel> getCommentsByPostId(Long postId);
}
