package com.rune.Jam.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String text;
    private String media;
    private String MIME;
    private Date date;
    private Integer upVoteCount;
    private Integer downVoteCount;

    @ManyToOne
    private User creator;

    @OneToOne
    private Channel contextChannel;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();;

    public Post(String text) {
        this.text = text;
        this.date = new Date();
    }

    public Post(String text, User creator, Channel contextChannel) {
        this.text = text;
        this.creator = creator;
        this.contextChannel = contextChannel;
    }
}
