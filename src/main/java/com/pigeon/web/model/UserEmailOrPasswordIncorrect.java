package com.pigeon.web.model;

public class UserEmailOrPasswordIncorrect extends Exception {
    public UserEmailOrPasswordIncorrect() {
        super("User email or password incorrect");
    }
}
