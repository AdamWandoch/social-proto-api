package com.adamwandoch.socialprotoapi;

import com.adamwandoch.socialprotoapi.models.user.UserModel;
import com.adamwandoch.socialprotoapi.models.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Adam Wandoch
 */

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/post")
    public ResponseEntity postUser(@RequestBody UserModel data) {
        userService.save(data);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/user/getall")
    public ArrayList<UserModel> getAllUsers() {
        return userService.getAll();
    }
}
