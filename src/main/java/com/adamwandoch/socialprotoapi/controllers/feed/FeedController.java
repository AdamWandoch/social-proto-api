package com.adamwandoch.socialprotoapi.controllers.feed;

import com.adamwandoch.socialprotoapi.models.post.PostModel;
import com.adamwandoch.socialprotoapi.models.post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author Adam Wandoch
 */

@Controller
public class FeedController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private PostService postService;

    @MessageMapping("/update")
    @SendTo("feed-update/public")
    public List<PostModel> feedUpdate() {
        return postService.getAllPosts();
    }

}
