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

//    @Autowired
//    private PostService postService;
//
//    @MessageMapping("/update")
//    @SendTo("feed-update/public")
//    public List<PostModel> feedUpdate() {
//        return postService.getAllPosts();
//    }

    @MessageMapping("/feed-trigger")
    @SendTo("/feed-clients")
    public String receiveMessage(@Payload String message) {
        return message;
    }

}
