package com.rune.Jam;

import lombok.Data;

@Data
public class Channel {
    private String name;
    private String logo;
    private String description;
    private String adress;
    private String email;
    private Boolean verified;
}
