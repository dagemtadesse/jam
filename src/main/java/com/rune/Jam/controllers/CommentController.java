package com.rune.Jam.controllers;

import com.rune.Jam.models.Post;
import com.rune.Jam.repositories.ChannelRepository;
import com.rune.Jam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CommentController {

    private final ChannelRepository channelRepo;
    private final UserRepository userRepo;

    @GetMapping("/channel/{channelId}")
    public String comment(@PathVariable Long channelId, Model model){
        var currentChan = channelRepo.findById(channelId);
        log.info("Fetched channel" + currentChan);

        if(currentChan.isPresent()){
            var channel = currentChan.get();
            var subChannels = channel.getSubChannels();
            var posts = channel.getPosts();

            model.addAttribute("currentChan", channel);
            model.addAttribute("subChans", subChannels);
            model.addAttribute("posts", posts);
            model.addAttribute("newPost", new Post());
        }

        return "channel";
    }

    @GetMapping("/prototype")
    public String showPrototype(){
        return "comment";
    }
}
