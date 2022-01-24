package com.rune.Jam.models;

import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentId;

    private String content;
    private Date date;
    private Integer upvoteCount;
    private Integer downVoteCount;

    @ManyToOne
    private Post post;

    @OneToOne
    private User user;

    public Comment(String content, Post post, User user) {
        this.content = content;
        this.post = post;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", upvoteCount=" + upvoteCount +
                ", downVoteCount=" + downVoteCount +
                ", user=" + user +
                '}';
    }
}
