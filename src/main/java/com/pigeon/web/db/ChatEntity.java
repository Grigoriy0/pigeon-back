package com.pigeon.web.db;

import com.pigeon.web.model.ChatType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chats")
@Getter
@Setter
public class ChatEntity implements Serializable {

    private static final long serialVersionUID = 7696060980312070187L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private ChatType chatType;

    private String chatName;

    @ManyToMany(mappedBy = "chats")
    private List<UserEntity> users = new ArrayList<>();

    @OneToMany(mappedBy = "chat")
    private List<MessageEntity> messages = new ArrayList<>();
}
