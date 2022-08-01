package com.adamwandoch.socialprotoapi.controllers;

import com.adamwandoch.socialprotoapi.models.user.UserModel;
import com.adamwandoch.socialprotoapi.models.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

/**
 * @author Adam Wandoch
 */

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;
    private UserController underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserController(userService);
    }

    @Test
    void canPostUser() {
        // given
        UserModel user = new UserModel();

        // when
        underTest.postUser(user);

        //then
        verify(userService).saveUser(user);
        verify(userService).getUserByNickname(user.getNickname());
    }

    @Test
    void canGetAllUsers() {
        // when
        underTest.getAllUsers();

        // then
        verify(userService).getAllUsers();
    }

    @Test
    void canGetUser() {
        // when
        underTest.getUser(123L);

        //
        verify(userService).getUser(123L);
    }
}