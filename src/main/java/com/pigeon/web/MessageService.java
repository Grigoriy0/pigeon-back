package com.pigeon.web;

import com.pigeon.web.db.MessageEntity;
import com.pigeon.web.db.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Iterable<MessageEntity> getUser() {
        return this.messageRepository.findAll();
    }

    public MessageEntity getUserById(Long id) {
        return this.messageRepository.findById(id).orElse(null);
    }

    public MessageEntity create(MessageEntity userEntity) {
        return messageRepository.save(userEntity);
    }

    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }
}
