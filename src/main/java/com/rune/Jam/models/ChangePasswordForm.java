package com.rune.Jam.models;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ChangePasswordForm {
    @NotNull
    @NotEmpty
    private String oldPassword;
    @NotNull
    @NotEmpty
    private String newPassword;
    @NotNull
    @NotEmpty
    private String cNewPassword;
}
