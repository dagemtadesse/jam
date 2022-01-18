package com.rune.Jam;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        return "home";
    }
    
}
