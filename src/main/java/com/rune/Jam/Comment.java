package com.rune.Jam;

import org.springframework.format.datetime.standard.DateTimeContext;
import lombok.Data;

@Data
public class Comment {
    private DateTimeContext date;
    private Integer upvoteCount;
    private Integer downvoteCount;
}
