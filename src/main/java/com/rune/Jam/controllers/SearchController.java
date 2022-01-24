package com.rune.Jam.controllers;

import com.rune.Jam.models.Channel;
import com.rune.Jam.repositories.ChannelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SearchController {

    private final ChannelRepository channelRepository;

    @GetMapping ("/search")
    public String search(@RequestParam(required = false) String channelName, Model model){

        log.info("incoming request" + channelName);
        var channels = new ArrayList<Channel>();
        Iterable<Channel> transaction;

        if(channelName == null){
            transaction = channelRepository.findAll();
            transaction.forEach(channels::add);
        }else {
            channels = (ArrayList<Channel>) channelRepository.findByNameIsLike(channelName);
        }

        model.addAttribute("chans", channels);
        model.addAttribute("matchResult", channels.size());
        return "final/search";
    }
}
