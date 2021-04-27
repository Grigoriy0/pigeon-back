package com.pigeon.web;

import com.pigeon.web.db.ChatEntity;
import com.pigeon.web.db.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Iterable<UserEntity> getUser() {
        return userService.getUser();
    }

    @GetMapping(value = "/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(value = "/name/{name}")
    public Iterable<UserEntity> getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping(value = "/{userId}/chat")
    public Iterable<ChatEntity> getUserChat(@PathVariable Long userId) {
        return userService.getUserChat(userId);
    }

    @GetMapping(value = "/registration/email/{email}")
    public boolean isRegistered(@PathVariable String email){
        return userService.isRegistered(email);
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.create(userEntity);
    }

//    @PostMapping(value = "/registration")
//    public UserEntity registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto, HttpServletRequest request, Errors errors) {
//        return userService.registerNewUserAccount(userDto);
//    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @DeleteMapping(value = "/{userId}/chat/{chatId}")
    public void deleteUserChat(@PathVariable Long userId, @PathVariable Long chatId) {
        userService.deleteUserChatByChatId(userId, chatId);
    }
}

