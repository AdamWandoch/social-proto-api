package com.adamwandoch.socialprotoapi.models.user;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Adam Wandoch
 */

@Entity
@Data
public class UserModel {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private int avatarId;
}
