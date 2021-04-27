package com.pigeon.web.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.*;

@Entity
@Table(name = "messages")
@Getter
@Setter
public class MessageEntity implements Serializable {
    private static final long serialVersionUID = 8272313331707744189L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnoreProperties({"messages"})
    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private ChatEntity chat;

    @JsonIgnoreProperties({"chats"})
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private LocalDateTime sendTime;

    private String text;
}
