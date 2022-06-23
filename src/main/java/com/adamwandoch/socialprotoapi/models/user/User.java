package com.adamwandoch.socialprotoapi.models.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author Adam Wandoch
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String nickname;
    private int avatar_id;

    public User() {
    }

    public User(long id, String nickname, int avatar_id) {
        this.id = id;
        this.nickname = nickname;
        this.avatar_id = avatar_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAvatar_id() {
        return avatar_id;
    }

    public void setAvatar_id(int avatar_id) {
        this.avatar_id = avatar_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, avatar_id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && avatar_id == user.avatar_id && Objects.equals(nickname, user.nickname);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", avatar_id=" + avatar_id +
                '}';
    }
}
