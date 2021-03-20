package com.example.demo.web;

import com.example.demo.web.db.UserEntity;
import com.example.demo.web.db.UserRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<UserEntity> getUser() {
        return this.userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public UserEntity create(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
