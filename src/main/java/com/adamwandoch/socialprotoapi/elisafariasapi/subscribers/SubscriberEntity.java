package com.adamwandoch.socialprotoapi.elisafariasapi.subscribers;

import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.entity.Emailable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Adam Wandoch
 */
@Entity
@Data
public class SubscriberEntity implements Emailable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    @Override
    public String toString() {
        return "SubscriberEntity{" +
                "\nname='" + name + '\'' +
                "\n, email='" + email + '\'' +
                '}';
    }
}
