package com.pigeon.web.db;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -2402998216354216363L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    private String username;

    private String password;

    @JsonIgnoreProperties({"user", "users", "messages"})
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"))
    private List<ChatEntity> chats = new ArrayList<>();
}
