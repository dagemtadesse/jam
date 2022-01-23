package com.rune.Jam.controllers;

import java.util.Arrays;
import java.util.List;

import com.rune.Jam.models.Channel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
    @GetMapping ("/search")
    public String search(Model model){
        model.addAttribute("naomi", Arrays.asList("naomi", "dagim"));

        // List<Channel> searchResult = Arrays.asList();
        
        return "search";
    }
}
