package com.pigeon.web;

import com.pigeon.web.db.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    public Iterable<MessageEntity> getUser() {
        return messageService.getUser();
    }

    @GetMapping(value = "/{id}")
    public MessageEntity getUserById(@PathVariable Long id) {
        return messageService.getUserById(id);
    }

    @PostMapping
    public MessageEntity createUser(@RequestBody MessageEntity userEntity) {
        return messageService.create(userEntity);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable Long id) {
        messageService.deleteById(id);
    }
}
