package com.adamwandoch.socialprotoapi.validation;

import java.util.regex.Pattern;

public class EmailValidator {

    private static final String REGEX_EMAIL = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";

    private EmailValidator() {
    }

    public static boolean IsEmailValid(String email) {
        return Pattern.compile(REGEX_EMAIL).matcher(email).matches();
    }
}
