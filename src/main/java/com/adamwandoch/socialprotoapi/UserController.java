package com.adamwandoch.socialprotoapi;

import com.adamwandoch.socialprotoapi.models.user.UserModel;
import com.adamwandoch.socialprotoapi.models.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Adam Wandoch
 */

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/post")
    public Long postUser(@RequestBody UserModel user) {
        userService.save(user);
        return userService.getUserId(user.getNickname());
    }

    @GetMapping("/user/getall")
    public ArrayList<UserModel> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    public Optional<UserModel> getUser(@PathVariable(value = "id") Long id) {
        return userService.getUser(id);
    }
}
