package com.rune.Jam.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long channel_id;

    @NotNull
    @Size(min = 3, message = "channel name should be at least 4 characters long ")
    private String name;

    private String logo;

    @NotNull
    @Size(min = 10, message = "channel name should be at least 4 characters long ")
    private String description;
   
    @NotNull
    @Pattern(regexp = "^([a-zA-Z\u0080-\u024F]+(?:. |-| |'))*[a-zA-Z\u0080-\u024F]*$", message = "enter a valid address")
    private String address;

    @NotNull
    @Pattern(regexp = "^(.+)@(.+)$", message = "should be in format example@domain.com")
    private String email;

    @NotNull
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

    @Override
    public String toString() {
        return "Channel{" +
                "channel_id=" + channel_id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", verified=" + verified +
                ", creator=" + creator.getId() +
                ", posts=" + posts +
                ", subChannels=" + subChannels +
                '}';
    }
}
