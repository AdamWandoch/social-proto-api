package com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.service;

import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.entity.EmailCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EmailCredentialProvider {

    @Autowired
    private Environment env;

    private EmailCredentialProvider() {
    }

    public EmailCredentials GetElisa() {
        return new EmailCredentials(
                env.getProperty("MAIL_USER_A"),
                env.getProperty("MAIL_PASSWORD_A"));
    }

    public EmailCredentials GetNoreply() {
        return new EmailCredentials(
                env.getProperty("MAIL_USER_NOREPLY"),
                env.getProperty("MAIL_PASSWORD_NOREPLY"));
    }
}
