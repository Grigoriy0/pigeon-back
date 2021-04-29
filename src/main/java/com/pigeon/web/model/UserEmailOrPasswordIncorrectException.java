package com.pigeon.web.model;

public class UserEmailOrPasswordIncorrectException extends Exception {
    public UserEmailOrPasswordIncorrectException() {
        super("User email or password incorrect");
    }
}
