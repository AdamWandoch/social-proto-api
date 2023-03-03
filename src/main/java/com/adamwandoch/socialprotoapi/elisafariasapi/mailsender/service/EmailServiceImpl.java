package com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.service;

import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.entity.EmailCredentials;
import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.entity.EmailDetails;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.entity.Emailable;
import com.adamwandoch.socialprotoapi.elisafariasapi.subscribers.SubscriberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

// Annotation
@Service
// Class
// Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;
    @Autowired
    private EmailCredentialProvider credentials;

    // To send a simple email
    public String sendSimpleMail(EmailDetails details, EmailCredentials credentials) {

        try {

            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(credentials.getUsername());
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            javaMailSenderImpl.setUsername(credentials.getUsername());
            javaMailSenderImpl.setPassword(credentials.getPassword());
            javaMailSenderImpl.send(mailMessage);
            return String.format("Mail Sent Successfully (FROM: %1$s, TO: %2$s)",
                    credentials.getUsername(),
                    details.getRecipient());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Error while Sending Mail";
        }
    }

    // To send an email with attachment
    public String sendMailWithAttachment(EmailDetails details, EmailCredentials credentials) {
        MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be sent
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(credentials.getUsername());
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(details.getSubject());

            // Adding the attachment
            FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            javaMailSenderImpl.send(mimeMessage);
            return "Mail sent Successfully";
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
            return "Error while sending mail!!!";
        }
    }

    public String sendWelcomeEmail(Emailable entity) {
        EmailDetails details = new EmailDetails();
        details.setSubject(String.format("Olá %s! Bem-vindo!", entity.getName()));
        details.setRecipient(entity.getEmail());
        details.setMsgBody(String.format(
                "Bem-vindo %s!\n" +
                        "\n" +
                        "Obrigada por subscrever a nossa newsletter!\n" +
                        "\nVou mantê-lo atualizado aqui, assim você não vai perder nada :)\n" +
                        "\n" +
                        "Abraços\n" +
                        "Elisa",
                entity.getName()));

        return sendSimpleMail(details, credentials.GetElisa());
    }

    public String sendNotificationEmail(Emailable entity) {
        EmailDetails details = new EmailDetails();
        details.setSubject("NEW SUBSCRIBER ADDED");
        details.setRecipient(credentials.GetElisa().getUsername());
        details.setMsgBody("New subscriber added: \n\n" + entity);

        return sendSimpleMail(details, credentials.GetNoreply());
    }

    public String sendContactFormConfirmationEmail(Emailable entity) {
        EmailDetails details = new EmailDetails();
        details.setSubject(String.format("Olá %s! Bem-vindo!", entity.getName()));
        details.setRecipient(entity.getEmail());
        details.setMsgBody(String.format(
                "Bem-vindo %s!\n" +
                        "\n" +
                        "Obrigada por contato!\n" +
                        "\nVou responder o mais rápido possível!\n" +
                        "\n" +
                        "Abraços\n" +
                        "Elisa",
                entity.getName()));

        return sendSimpleMail(details, credentials.GetElisa());
    }

    public String sendContactFormNotificationEmail(Emailable entity) {
        EmailDetails details = new EmailDetails();
        details.setSubject("New Data Entered on ElisaFarias.com");
        details.setRecipient(credentials.GetElisa().getUsername());
        details.setMsgBody("Data captured: \n\n" + entity);

        return sendSimpleMail(details, credentials.GetNoreply());
    }
}
