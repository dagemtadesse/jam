package com.rune.Jam;

@Controller
public class HomeController {
    @GetMapping(value="/")
    public String home(){
        return "home";
    }
    
}
