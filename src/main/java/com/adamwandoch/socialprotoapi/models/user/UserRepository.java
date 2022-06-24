package com.adamwandoch.socialprotoapi.models.user;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Adam Wandoch
 */

public interface UserRepository extends CrudRepository<UserModel, Long> {

    UserModel findByNickname(String nickname);

    boolean existsByNickname(String nickname);
}
