package com.adamwandoch.socialprotoapi.controllers.websocket;

import com.adamwandoch.socialprotoapi.models.post.PostModel;
import com.adamwandoch.socialprotoapi.models.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Adam Wandoch
 */

@Controller
public class FeedController {

    @Autowired
    private PostService postService;

    public FeedController(PostService postService) {
        this.postService = postService;
    }

    @MessageMapping("/feed-trigger")
    @SendTo("/feed-clients")
    public List<PostModel> receiveMessage(@Payload String message) throws InterruptedException {
        Thread.sleep(500); // allow repository to save new data from client
        return postService.getAllPosts();
    }

}
