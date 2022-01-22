package com.rune.Jam.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@RequiredArgsConstructor
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
}
