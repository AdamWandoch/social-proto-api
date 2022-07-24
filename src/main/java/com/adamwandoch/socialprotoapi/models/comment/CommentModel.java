package com.adamwandoch.socialprotoapi.models.comment;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Adam Wandoch
 */

@Data
@Entity
public class CommentModel {

    @Id
    @GeneratedValue
    private Long id;
    private Long postId;
    private Long userId;
    private String content;
    private String timestamp;
}
