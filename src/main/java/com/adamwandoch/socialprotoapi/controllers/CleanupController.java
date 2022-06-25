package com.adamwandoch.socialprotoapi.controllers;

import com.adamwandoch.socialprotoapi.models.post.PostRepository;
import com.adamwandoch.socialprotoapi.models.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Adam Wandoch
 */

@RestController
@CrossOrigin
public class CleanupController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    public static final Logger LOG = LoggerFactory.getLogger(CleanupController.class);

    @GetMapping("/clear")
    public String wipeClean() {
        String message = "WIPEOUT COMPLETE";
        userRepository.deleteAll();
        postRepository.deleteAll();
        LOG.info(message);
        return message;
    }

}
