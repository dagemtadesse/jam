package com.rune.Jam.repositories;

import com.rune.Jam.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
