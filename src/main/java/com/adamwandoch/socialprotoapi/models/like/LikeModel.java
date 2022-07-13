package com.adamwandoch.socialprotoapi.models.like;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Adam Wandoch
 */

@Entity
@Data
public class LikeModel {

    @Id
    @GeneratedValue
    private Long id;
    private Long postId;
    private Long userId;
}
