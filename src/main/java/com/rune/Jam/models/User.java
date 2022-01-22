package com.rune.Jam.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
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

    public User(String fullName, String userHandle, String email, String phoneNumber, String occupation, Role userRole) {
        this.fullName = fullName;
        this.userHandle = userHandle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.occupation = occupation;
        this.userRole = userRole;
    }

    public static enum Role {
        REGULAR, ADMIN
    }
}
