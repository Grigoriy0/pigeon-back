package com.pigeon.web;

import com.pigeon.web.db.ChatEntity;
import com.pigeon.web.db.ChatRepository;
import com.pigeon.web.db.MessageEntity;
import com.pigeon.web.db.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    public Iterable<ChatEntity> getChat() {
        return chatRepository.findAll();
    }

    public ChatEntity getChatById(Long chatId) {
        return chatRepository.findById(chatId).orElse(null);
    }

    public Iterable<MessageEntity> getChatMessage(Long chatId) {
        return getChatById(chatId).getMessages();
    }

    public void deleteById(Long id) {
        chatRepository.deleteById(id);
    }

    public ChatEntity create(ChatEntity chatEntity) {
        return chatRepository.save(chatEntity);
    }

    public void addUserById(Long chatId, UserEntity user) {
        getChatById(chatId).getUsers().add(user);
    }
}
