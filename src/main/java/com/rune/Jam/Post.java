package com.rune.Jam;

@Data
public class Post {
    private String text;
    private String media;
    private String MIME;
    private DateTimeContext date;
    private Integer upvoteCount;
    private Integer downvoteCount;
}
