package com.pigeon.web;

import com.pigeon.web.db.MessageEntity;
import com.pigeon.web.db.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Iterable<MessageEntity> getMessage() {
        return this.messageRepository.findAll();
    }

    public MessageEntity getMessageById(Long id) {
        return messageRepository
                .findById(id)
                .orElse(null);
    }

    public MessageEntity create(MessageEntity messageEntity) {
        return messageRepository.save(messageEntity);
    }

    public void deleteById(Long id) {
        messageRepository.deleteById(id);
    }

    public Iterable<MessageEntity> getMessageByUserId(Long userId) {
        ArrayList<MessageEntity> messages = (ArrayList<MessageEntity>) messageRepository.findAll();
        return messages.stream()
                .filter(m -> m.getUser().getId() == userId)
                ::iterator;
    }
}
