package com.rune.Jam;

<<<<<<< HEAD
import org.springframework.format.datetime.standard.DateTimeContext;
=======
import java.util.Date;

>>>>>>> 324b99530ccc9f22455d6ba6a3c9204dcfdf36ac
import lombok.Data;

@Data
public class Post {
    private String text;
    private String media;
    private String MIME;
    private Date date;
    private Integer upvoteCount;
    private Integer downvoteCount;
}
