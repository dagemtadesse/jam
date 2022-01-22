package com.rune.Jam.models;

import java.sql.Date;
import lombok.Data;

@Data
public class Comment {
    private Date date;
    private Integer upvoteCount;
    private Integer downvoteCount;
}
