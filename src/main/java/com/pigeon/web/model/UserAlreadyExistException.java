package com.pigeon.web.model;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException() {
        super("User already exist");
    }
}
