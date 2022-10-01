package com.adamwandoch.socialprotoapi.elisafariasapi.subscribers;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Adam Wandoch
 */
@Entity
@Data
public class SubscriberEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
}
