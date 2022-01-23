package com.rune.Jam.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(message = "Enter a valid full name")
    private String fullName;

    @NotNull
    @Pattern(regexp = "^(.+)@(.+)$", message = "should be in format example@domain.com")
    private String email;

    @NotNull
    private String address;

    @NotNull
    private String password;

    private String occupation;

    @Enumerated(EnumType.STRING)
    private Role userRole;

    @OneToMany
    private List<Channel> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    private List<Channel> createdChannels = new ArrayList<>();

    public User(String fullName,  String email, String address, String password) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.password = password;
        this.userRole = Role.REGULAR;
    }

    public static enum Role {
        REGULAR, ADMIN
    }
}
