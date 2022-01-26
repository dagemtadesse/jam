package com.rune.Jam.models;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.*;

@Data
public class RegistrationForm {
    @NotNull
    @Size(min = 3, message = "field must be at least 5 characters long.")
    private String fullName;

    @NotNull
    @Size(min = 3, message = "field must be at least 5 characters long.")
    private String address;
    
    @Email
    @NotNull
    @NotBlank(message = "email is required")
    @Pattern(regexp = "^(.+)@(.+)$", message = "should be in format example@domain.com")
    private String email;


    @Size(min = 5, message = "field must be at least 5 characters long.")
    private String password;

    @NotNull
    @Size(min = 3, message = "field must be at least 5 characters long.")
    private String cPassword;

    private Boolean isAdmin = false;

    public User toUser(PasswordEncoder encoder) {
        return new User(
                this.getFullName(),
                encoder.encode(this.getPassword()),
                this.getEmail(),
                this.getAddress(),
                this.getIsAdmin() ? User.Role.ADMIN : User.Role.REGULAR
        );
    }
}
