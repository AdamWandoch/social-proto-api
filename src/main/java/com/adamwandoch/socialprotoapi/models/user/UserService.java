package com.adamwandoch.socialprotoapi.models.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Adam Wandoch
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService() {
    }

    public ArrayList<UserModel> getAll() {
        ArrayList<UserModel> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public Long getUserId(String nickname) {
        if (userRepository.existsByNickname(nickname)) {
            return userRepository.findByNickname(nickname).getId();
        }
        return -1L;
    }

    public Optional<UserModel> getUser(Long id) {
        return userRepository.findById(id);
    }

    public void save(UserModel user) {
        if (!userRepository.existsByNickname(user.getNickname())) {
            userRepository.save(user);
        } else {
            UserModel existingUser = userRepository.findByNickname(user.getNickname());
            if (existingUser != null) {
                existingUser.setAvatarId(user.getAvatarId());
                userRepository.save(existingUser);
            }
        }
    }
}
