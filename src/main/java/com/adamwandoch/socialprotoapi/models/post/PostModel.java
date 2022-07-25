package com.adamwandoch.socialprotoapi.models.post;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Adam Wandoch
 */

@Entity
@Data
public class PostModel {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String content;
    private String timestamp;
    private int likes = 0;
    private int comments = 0;
}
