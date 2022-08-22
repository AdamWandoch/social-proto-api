package com.adamwandoch.socialprotoapi.controllers;

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
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/post")
    public UserModel postUser(@RequestBody UserModel user) {
        userService.saveUser(user);
        return userService.getUserByNickname(user.getNickname());
    }

    @GetMapping("/user/getall")
    public ArrayList<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public Optional<UserModel> getUser(@PathVariable(value = "id") Long id) {
        return userService.getUser(id);
    }
}
