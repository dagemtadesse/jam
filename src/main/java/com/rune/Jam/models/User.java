package com.rune.Jam.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
    @NotBlank(message = "name is required")
    @Size(min = 5 , message = "name must be at least 5 characters long")
    private String fullName;

    @Email
    @NotNull(message = "email is required")
    @NotEmpty
    @Pattern(regexp = "^(.+)@(.+)$", message = "should be in format example@domain.com")
    private String email;

    @NotNull
    private String address;

    @Min(8)
    @Max(30)
    @NotNull
    @NotBlank(message = "password is required")
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

    public User(String string, String string2, String string3, String string4, String string5, Role regular) {
    }

    public static enum Role {
        REGULAR, ADMIN
    }
}
