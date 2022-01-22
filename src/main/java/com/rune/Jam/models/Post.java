package com.rune.Jam.models;

import java.util.Date;
import java.util.Set;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
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
    private Set<Comment> comments;
}
