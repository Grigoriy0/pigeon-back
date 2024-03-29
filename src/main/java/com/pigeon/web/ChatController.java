package com.pigeon.web;

import com.pigeon.web.db.ChatEntity;
import com.pigeon.web.db.MessageEntity;
import com.pigeon.web.db.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping
    public Iterable<ChatEntity> getChat() {
        return chatService.getChat();
    }

    @GetMapping(value = "/{id}")
    public ChatEntity getChatById(@PathVariable Long id) {
        return chatService.getChatById(id);
    }

    @GetMapping(value = "/{chatId}/message")
    public Iterable<MessageEntity> getChat(@PathVariable Long chatId) {
        return chatService.getChatMessage(chatId);
    }

    @PostMapping
    public ChatEntity createChat(@RequestBody ChatEntity chatEntity) {
        return chatService.create(chatEntity);
    }

    @PatchMapping(value = "/{chatId}/user")
    public void addUserById(@PathVariable Long chatId, @RequestBody UserEntity user) {
        chatService.addUserById(chatId, user);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteChat(@PathVariable Long id) {
        chatService.deleteById(id);
    }

}
