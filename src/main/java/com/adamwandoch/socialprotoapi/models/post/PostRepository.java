package com.adamwandoch.socialprotoapi.models.post;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Adam Wandoch
 */

public interface PostRepository extends CrudRepository<PostModel, Long> {
}
