package com.pigeon.web;

import com.pigeon.web.db.ChatEntity;
import com.pigeon.web.db.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Iterable<UserEntity> getUser() {
        return userService.getUser();
    }

    @GetMapping(value = "/id/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/name/{name}")
    public Iterable<UserEntity> getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping(value = "{userId}/chat")
    public Iterable<ChatEntity> getUserChat(@PathVariable Long userId) {
        return userService.getUserChat(userId);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.create(userEntity);
    }

    @DeleteMapping(value = "{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @DeleteMapping(value = "/{userId}/chat/{chatId}")
    public void deleteUserChat(@PathVariable Long userId, @PathVariable Long chatId) {
        userService.deleteUserChatByChatId(userId, chatId);
    }
}

