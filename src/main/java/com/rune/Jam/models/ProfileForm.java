package com.rune.Jam.models;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class ProfileForm {

    @NotNull
    @NotBlank(message = "name is required")
    @Size(min = 5 , message = "name must be at least 5 characters long")
    private String fullName;

    @Email
    @NotNull(message = "email is required")
    @NotEmpty
    private String email;

    @NotBlank
    private String address;
}
