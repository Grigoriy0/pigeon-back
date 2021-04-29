package com.pigeon.web.model;

public class UserNotRegistered extends Exception {
    public UserNotRegistered(){
        super("User not Registered");
    }
}
