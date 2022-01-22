package com.rune.Jam.models;

import java.util.Date;
import lombok.Data;

@Data
public class Post {
    private String text;
    private String media;
    private String MIME;
    private Date date;
    private Integer upVoteCount;
    private Integer downVoteCount;
}
