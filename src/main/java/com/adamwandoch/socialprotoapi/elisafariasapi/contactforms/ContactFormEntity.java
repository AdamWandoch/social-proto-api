package com.adamwandoch.socialprotoapi.elisafariasapi.contactforms;

import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.entity.Emailable;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ContactFormEntity implements Emailable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String message;

    @Override
    public String toString() {
        return "Contact Form Data" +
                "\nName: " + name +
                "\nLast Name: " + lastName +
                "\nEmail: " + email +
                "\nMessage: " + message;
    }
}
