package com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailCredentials {

    private String username;
    private String password;
}
