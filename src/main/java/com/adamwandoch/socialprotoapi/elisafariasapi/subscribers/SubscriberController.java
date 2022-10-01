package com.adamwandoch.socialprotoapi.elisafariasapi.subscribers;

import com.adamwandoch.socialprotoapi.elisafariasapi.mailsender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;

import static com.adamwandoch.socialprotoapi.validation.EmailValidator.IsEmailValid;

@RestController
@CrossOrigin(origins = {"https://elisafarias.netlify.app/", "http://localhost:3000"})
@RequestMapping("/efapi/subscriber")
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private EmailService emailService;

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSubscriber(@RequestBody SubscriberEntity subscriber) {
        URI location = URI.create("addSubscriberURIlocation");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        responseHeaders.set("Custom header name", "Custom header value");
        String responseBody;
        // validate email
        if (IsEmailValid(subscriber.getEmail())) {
            // if valid, try adding to db
            if (subscriberService.addSubscriber(subscriber)) {
                // send welcome email to user
                emailService.sendWelcomeEmail(subscriber);
                // send notification email to elisa
                responseBody = emailService.sendNotificationEmail(subscriber);
                // return success response
                return new ResponseEntity<String>(responseBody, responseHeaders, HttpStatus.CREATED);
            }
            // return response with "email already taken"
            responseBody = "Email already taken!";
            return new ResponseEntity<String>(responseBody, responseHeaders, HttpStatus.FORBIDDEN);
        }
        // return response with "email invalid"
        responseBody = "Email failed validation. Check email format.";
        return new ResponseEntity<String>(responseBody, responseHeaders, HttpStatus.FORBIDDEN);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ArrayList<SubscriberEntity>> getAllSubscribers() {
        URI location = URI.create("getAllSubscribersURIlocation");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        responseHeaders.set("Custom header name", "Custom header value");
        ArrayList<SubscriberEntity> responseBody = subscriberService.getAllSubscribers();
        return new ResponseEntity<>(responseBody, responseHeaders, HttpStatus.OK);
    }
}
