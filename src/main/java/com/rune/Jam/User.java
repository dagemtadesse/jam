package com.rune.Jam;

public class User {
    private String fullName;
    private String userHandle;
    private String email;
    private String phoneNumber;
    private String occupation;
    private Role userRole;

    public static enum Role {
        REGULAR, ADMIN
    }
}
