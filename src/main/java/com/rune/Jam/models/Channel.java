package com.rune.Jam.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long channel_id;

    private String name;
    private String logo;
    private String description;
    private String address;
    private String email;
    private Boolean verified;

    @ManyToOne
    private User creator;

    @OneToMany(mappedBy = "contextChannel")
    private List<Post> posts = new ArrayList<>();;

    @ManyToOne
    private Channel parentChannel;

    @OneToMany(mappedBy = "parentChannel")
    private List<Channel> subChannels = new ArrayList<>();;

    public Channel(String name, String logo, String description, String address, String email, Boolean verified) {
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.address = address;
        this.email = email;
        this.verified = verified;
    }
}
