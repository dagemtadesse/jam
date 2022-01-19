package com.rune.Jam;

import org.springframework.format.datetime.standard.DateTimeContext;
import lombok.Data;

@Data
public class Post {
    private String text;
    private String media;
    private String MIME;
    private DateTimeContext date;
    private Integer upvoteCount;
    private Integer downvoteCount;
}
