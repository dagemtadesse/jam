package com.rune.Jam;

import lombok.Data;

@Data
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 324b99530ccc9f22455d6ba6a3c9204dcfdf36ac
