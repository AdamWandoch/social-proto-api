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
    private Long id;
    private String nickname;
    private int avatarId;

    public UserModel() {
    }

    public UserModel(Long id, String nickname, int avatar) {
        this.id = id;
        this.nickname = nickname;
        this.avatarId = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, avatarId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel user = (UserModel) o;
        return id == user.id && avatarId == user.avatarId && Objects.equals(nickname, user.nickname);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", avatar=" + avatarId +
                '}';
    }
}
