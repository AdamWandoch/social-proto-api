package com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter

public class EmailCredentials {
    private String username;
    private String password;
}
