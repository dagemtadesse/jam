package com.rune.Jam.controllers;

import com.rune.Jam.models.Channel;
import com.rune.Jam.models.Post;
import com.rune.Jam.repositories.ChannelRepository;
import com.rune.Jam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
public class CommentController {

    private final ChannelRepository channelRepo;
    private final UserRepository userRepo;

    @GetMapping("/channel/{channelId}")
    public String comment(@PathVariable Long channelId, Model model,  Authentication authentication){
        var currentChan = channelRepo.findById(channelId);
        log.info("Fetched channel" + currentChan);

        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);
        model.addAttribute("user", user);

        if(currentChan.isPresent()){
            var channel = currentChan.get();
            var subChannels = channel.getSubChannels();
            var posts = channel.getPosts();

            model.addAttribute("currentChan", channel);
            model.addAttribute("subChans", subChannels);
            model.addAttribute("posts", posts);
            model.addAttribute("newPost", new Post());
        }

        return "final/channel";
    }

    @PostMapping("/bookmark/{channelId}")
    public String SaveBookmark(@PathVariable Long channelId, Authentication authentication){
        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);
        var channel = channelRepo.findById(channelId);
        log.info("userName-XXX"+authentication.getName());

        if(user != null && channel.isPresent()){
            if(user.getBookmarks() != null) {
                user.getBookmarks().add(channel.get());
            }else {
                user.setBookmarks(Arrays.asList(channel.get()));
            }
            userRepo.save(user);
        }

        return "redirect:/search";
    }

    @PostMapping("/removeBookmark/{channelId}")
    public String removeBookmark(@PathVariable Long channelId, Authentication authentication) {
        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);

        var newBookmarks = user.getBookmarks()
                .stream()
                .filter(chan -> chan.getChannel_id() != channelId)
                .collect(Collectors.toList());
        user.setBookmarks(newBookmarks);

        userRepo.save(user);
        return "redirect:/search";
    }
}
