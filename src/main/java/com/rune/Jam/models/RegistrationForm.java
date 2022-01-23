package com.rune.Jam.models;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm {
    @NotNull
    @Size(min = 3, message = "field must be at least 5 characters long.")
    private String fullName;

    @NotNull
    @Size(min = 3, message = "field must be at least 5 characters long.")
    private String address;

    @NotNull
    @Pattern(regexp = "^(.+)@(.+)$", message = "should be in format example@domain.com")
    private String email;

    @NotNull
    @Size(min = 3, message = "field must be at least 5 characters long.")
    private String password;

    @NotNull
    @Size(min = 3, message = "field must be at least 5 characters long.")
    private String cPassword;
}
