package com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.service;

import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.entity.EmailCredentials;
import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.entity.EmailDetails;
import com.adamwandoch.socialprotoapi.elisafariasapi.subscribers.SubscriberEntity;

public interface EmailService {
    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details, EmailCredentials credentials);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details, EmailCredentials credentials);

    String sendWelcomeEmail(SubscriberEntity subscriber);

    String sendNotificationEmail(SubscriberEntity subscriber);
}
