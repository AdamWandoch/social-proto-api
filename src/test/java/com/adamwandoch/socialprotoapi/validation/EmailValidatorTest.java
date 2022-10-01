package com.adamwandoch.socialprotoapi.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.adamwandoch.socialprotoapi.validation.EmailValidator.IsEmailValid;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class EmailValidatorTest {

    private EmailValidator underTest;

    @BeforeEach
    void setUp() {
//        underTest = new EmailValidator();
    }

    @Test
    void canValidateEmail() {
        // given
        String email1 = "ad";
        String email2 = "@ad";
        String email3 = "ad@";
        String email4 = "ad@as";
        String email5 = "ad@1231*^";
        String email6 = "@";
        String email7 = "*&*&%*%....____";
        String email8 = "user@domain.com";
        String email9 = "user@domain.com.br";
        String email10 = "us&er@domain.com.br";
        // when
        // then
        assertThat(IsEmailValid(email1)).isFalse();
        assertThat(IsEmailValid(email2)).isFalse();
        assertThat(IsEmailValid(email3)).isFalse();
        assertThat(IsEmailValid(email4)).isFalse();
        assertThat(IsEmailValid(email5)).isFalse();
        assertThat(IsEmailValid(email6)).isFalse();
        assertThat(IsEmailValid(email7)).isFalse();
        assertThat(IsEmailValid(email8)).isTrue();
        assertThat(IsEmailValid(email9)).isTrue();
        assertThat(IsEmailValid(email10)).isFalse();
    }
}