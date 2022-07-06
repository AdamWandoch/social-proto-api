package com.adamwandoch.socialprotoapi.models.post;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;

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
    @Column(length = 20000)
    private ArrayList<Long> usersThatLiked = new ArrayList<>();

    public void like(Long userId) {
        this.likes++;
        this.usersThatLiked.add(userId);
    }

    public void addUserThatLiked(Long userId) {
        this.usersThatLiked.add(userId);
    }
}
