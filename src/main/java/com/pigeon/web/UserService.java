package com.pigeon.web;

import com.pigeon.web.db.ChatEntity;
import com.pigeon.web.db.UserEntity;
import com.pigeon.web.db.UserRepository;
import com.pigeon.web.db.VerificationTokenRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Objects;

@Service
//@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private VerificationTokenRepository tokenRepository;

    public Iterable<UserEntity> getUser() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository
                .findById(id)
                .orElse(null);
    }

    public UserEntity create(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public Iterable<UserEntity> getUserByName(String text) {
        ArrayList<UserEntity> users = (ArrayList<UserEntity>) getUser();
        return users.stream()
                .filter(u -> u.getUsername().contains(text))
                ::iterator;
    }

    public Iterable<ChatEntity> getUserChat(Long userId) {
        return getUserById(userId).getChats();
    }

    public void deleteUserChatByChatId(Long userId, Long chatId) {
        ArrayList<ChatEntity> userChats = (ArrayList<ChatEntity>) getUserChat(userId);
        userChats.removeIf(c -> c.getId() == chatId);
    }

    public boolean isRegistered(String email) {
        ArrayList<UserEntity> users = (ArrayList<UserEntity>) getUser();
        UserEntity user = users.stream()
                .filter(u -> Objects.equals(u.getEmail(), email))
                .findAny()
                .orElse(null);
        return user != null;
    }

//    public UserEntity registerNewUserAccount(UserDto userDto) throws UserAlreadyExistException {
//
//    }
}
