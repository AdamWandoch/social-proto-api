package com.adamwandoch.socialprotoapi.elisafariasapi.subscribers;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Adam Wandoch
 */

public interface SubscriberRepository extends CrudRepository<SubscriberEntity, Long> {

    Optional<SubscriberEntity> findByEmail(String email);
}
