package com.pigeon.web.model;

import lombok.NonNull;
import lombok.Getter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.security.SecureRandom.getInstance;

@Getter
public class UserPasswordHashing {
    private final byte[] salt = new byte[16];
    private String generatedPassword = null;

    public UserPasswordHashing(@NonNull String passwordToHash) {
        try {
            getInstance("SHA1PRNG").nextBytes(salt);

            MessageDigest md = MessageDigest.getInstance("SHA-1");

            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString(aByte + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException ignored) {
            generatedPassword = Integer.toString(passwordToHash.hashCode(), 16);
        }
    }

}
