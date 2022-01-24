package com.rune.Jam.controllers;

import com.rune.Jam.models.Post;
import com.rune.Jam.repositories.ChannelRepository;
import com.rune.Jam.repositories.PostRepository;
import com.rune.Jam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PostController {

    private final PostRepository postRepo;
    private final UserRepository userRepo;
    private final ChannelRepository chanRepo;

    @PostMapping("/{userId}/create-post/{channelId}")
    public String createPost(@PathVariable Long  userId, @PathVariable Long channelId,  Post newPost){
        var user = userRepo.findById(userId);
        var channel = chanRepo.findById(channelId);

        if( user.isPresent() && channel.isPresent()){
            newPost.setCreator(user.get());
            newPost.setContextChannel(channel.get());
            newPost.setDate(new Date());
            postRepo.save(newPost);
        }

        return "channel";
    }
}
