package com.rune.Jam.models;

import java.sql.Date;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentId;
    
    private Date date;
    private Integer upvoteCount;
    private Integer downvoteCount;

    @ManyToOne
    private Post post;

    @OneToOne
    private User user;
}
