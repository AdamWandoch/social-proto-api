package com.adamwandoch.socialprotoapi.elisafariasapi.subscribers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.adamwandoch.socialprotoapi.validation.EmailValidator.IsEmailValid;

@RestController
@CrossOrigin(origins = {"https://elisafarias.netlify.app/", "http://localhost:3000"})
@RequestMapping("/efapi/subscriber")
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @PostMapping("/add")
    public SubscriberEntity addSubscriber(@RequestBody SubscriberEntity subscriber) {

        // validate email
        if (IsEmailValid(subscriber.getEmail())) {
            // if valid, try adding to db
            if (subscriberService.addSubscriber(subscriber)) {
                // send welcome email to user
                // send notification email to elisa
                // return success response
            }
            // return response with "email already taken"
        }
        // return response with "email invalid"
    }
}
