package com.pigeon.web.model;

public class UserNotRegisteredException extends Exception {
    public UserNotRegisteredException() {
        super("User not Registered");
    }
}
