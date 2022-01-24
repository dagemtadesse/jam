package com.rune.Jam.repositories;

import com.rune.Jam.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findUserByEmail(String email);
}
