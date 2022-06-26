package com.adamwandoch.socialprotoapi.models.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author Adam Wandoch
 */

@Entity
public class PostModel {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String content;
    private String timestamp;
    private int likes;

    public PostModel(Long id, Long userId, String content, String timestamp, int likes) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.timestamp = timestamp;
        this.likes = likes;
    }

    public PostModel() {
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, content, timestamp, likes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostModel postModel = (PostModel) o;
        return likes == postModel.likes && Objects.equals(id, postModel.id) && Objects.equals(userId, postModel.userId) && Objects.equals(content, postModel.content) && Objects.equals(timestamp, postModel.timestamp);
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", likes=" + likes +
                '}';
    }
}
