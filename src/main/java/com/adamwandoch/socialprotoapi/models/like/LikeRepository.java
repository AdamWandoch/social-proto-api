package com.adamwandoch.socialprotoapi.models.like;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Adam Wandoch
 */

public interface LikeRepository extends CrudRepository<LikeModel, Long> {
}
