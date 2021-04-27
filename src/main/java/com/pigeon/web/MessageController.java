package com.pigeon.web;

import com.pigeon.web.db.ChatEntity;
import com.pigeon.web.db.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public Iterable<MessageEntity> getMessage() {
        return messageService.getMessage();
    }

    @GetMapping(value = "/{id}")
    public MessageEntity getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    @GetMapping(value = "/chat/{chatId}")
    public Iterable<MessageEntity> getMessageByChatId(@PathVariable Long chatId) {
        return messageService.getMessageByChatId(chatId);
    }

    @GetMapping(value = "/user/{userId}")
    public Iterable<MessageEntity> getMessageByUserId(@PathVariable Long userId) {
        return messageService.getMessageByUserId(userId);
    }

    @PostMapping
    public MessageEntity createMessage(@RequestBody MessageEntity messageEntity) {
        return messageService.create(messageEntity);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteById(id);
    }
}
