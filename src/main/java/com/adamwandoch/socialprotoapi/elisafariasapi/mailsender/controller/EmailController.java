package com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.controller;

import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.entity.EmailDetails;
import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Annotation
@RestController
@CrossOrigin(origins = {"https://elisafarias.netlify.app/", "http://localhost:3000"})
@RequestMapping("/efapi")
// Class
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Sending a simple Email
//    @PostMapping("/sendMail")
//    public String sendMail(@RequestBody EmailDetails details) {
//        String status = emailService.sendSimpleMail(details);
//        return status;
//    }

    // Sending email with attachment
//    @PostMapping("/sendMailWithAttachment")
//    public String sendMailWithAttachment(@RequestBody EmailDetails details) {
//        String status = emailService.sendMailWithAttachment(details);
//        return status;
//    }
}
