package com.adamwandoch.socialprotoapi.controllers.feed;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author Adam Wandoch
 */

@Controller
public class FeedController {

    @MessageMapping("/feed-trigger")
    @SendTo("/feed-clients")
    public String receiveMessage(@Payload String message) {
        return message;
    }

}
