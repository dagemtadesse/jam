package com.rune.Jam.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
public class User implements UserDetails {
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
    private String email;

    @NotNull
    private String password;

    @NotBlank
    private String address;


    @Enumerated(EnumType.STRING)
    private Role userRole;

    @OneToMany
    private List<Channel> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    private List<Channel> createdChannels = new ArrayList<>();

    public User(String fullName,  String password, String email, String address, Role role) {
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.password = password;
        this.userRole = role;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("Role-XXX" + this.getUserRole().name());
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_"+this.getUserRole().name()));
    }

    @Override
    public String getUsername() {
        return this.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;}

    public static enum Role {
        REGULAR, ADMIN
    }
}
