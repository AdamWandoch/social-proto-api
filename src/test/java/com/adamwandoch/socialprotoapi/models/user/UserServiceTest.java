package com.adamwandoch.socialprotoapi.models.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

/**
 * @author Adam Wandoch
 */

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository);
    }

    @Test
    void getAllUsers() {
        // when
        underTest.getAllUsers();
        // then
        verify(userRepository).findAll();
    }

    @Test
    @Disabled
    void getUser() {
    }

    @Test
    @Disabled
    void getUserByNickname() {
    }

    @Test
    @Disabled
    void saveUser() {
    }
}