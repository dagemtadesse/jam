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
    @Pattern(regexp = "^[a-zA-Z]{4,}(?: [a-zA-Z]+)?(?: [a-zA-Z]+)?$", message = "Enter a valid Fullname")
    private String fullName;

    @NotNull
    @Pattern(regexp = "^([a-zA-Z])+([\\w]{2,})+$", message = "Enter a valid username")
    private String userHandle;

    @NotNull
    @Pattern(regexp = "^(.+)@(.+)$", message = "should be in format example@domain.com")
    private String email;

    @NotNull
    @Pattern(regexp = "^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$", message = "should be in format +251 9xx xxx xxx")
    private String phoneNumber;

    @NotNull
    @Size(min = 7, message = "choose either 'student' or 'employee'.")
    private String occupation;

    @Enumerated(EnumType.STRING)
    private Role userRole;

    @OneToMany
    private List<Channel> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    private List<Channel> createdChannels = new ArrayList<>();

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
