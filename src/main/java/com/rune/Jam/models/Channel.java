package com.rune.Jam.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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
    private Set<Post> posts;

    @ManyToOne
    private Channel parentChannel;

    @OneToMany(mappedBy = "parentChannel")
    private Set<Channel> subChannels;

    public Channel(String name, String logo, String description, String address, String email, Boolean verified) {
        this.name = name;
        this.logo = logo;
        this.description = description;
        this.address = address;
        this.email = email;
        this.verified = verified;
    }
}
