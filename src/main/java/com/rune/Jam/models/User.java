package com.rune.Jam.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String fullName;
    private String userHandle;
    private String email;
    private String phoneNumber;
    private String occupation;

    @Enumerated(EnumType.STRING)
    private Role userRole;

    @OneToMany
    private Set<Channel> bookmarks;

    @OneToMany(mappedBy = "creator")
    private Set<Channel> createdChannels;

    public static enum Role {
        REGULAR, ADMIN
    }
}
