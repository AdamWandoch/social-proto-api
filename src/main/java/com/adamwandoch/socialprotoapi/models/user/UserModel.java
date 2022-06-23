package com.adamwandoch.socialprotoapi.models.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @author Adam Wandoch
 */

@Entity
public class UserModel {

    @Id
    @GeneratedValue
    private long id;
    private String nickname;
    private int avatar;

    public UserModel() {
    }

    public UserModel(long id, String nickname, int avatar) {
        this.id = id;
        this.nickname = nickname;
        this.avatar = avatar;
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

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, avatar);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel user = (UserModel) o;
        return id == user.id && avatar == user.avatar && Objects.equals(nickname, user.nickname);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
