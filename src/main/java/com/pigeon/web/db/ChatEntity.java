package com.pigeon.web.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pigeon.web.model.ChatType;
import jdk.nashorn.internal.ir.annotations.Ignore;
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

    @JsonIgnoreProperties(value = "chats", allowSetters = true)
    @ManyToMany(mappedBy = "chats", cascade = CascadeType.ALL)
    private List<UserEntity> users = new ArrayList<>();

    @JsonIgnoreProperties(value = "chat", allowSetters = true)
    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<MessageEntity> messages = new ArrayList<>();
}
