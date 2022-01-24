package com.rune.Jam.repositories;

import com.rune.Jam.models.Channel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChannelRepository extends CrudRepository<Channel, Long> {
    public List<Channel> findByNameIsLike(String name);
}
