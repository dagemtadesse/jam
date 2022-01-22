package com.rune.Jam.repositories;

import com.rune.Jam.models.Bookmark;
import org.springframework.data.repository.CrudRepository;

public interface BookMarkRepository extends CrudRepository<Bookmark, Long> {
}
