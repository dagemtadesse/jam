package com.rune.Jam.repositories;

import com.rune.Jam.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
