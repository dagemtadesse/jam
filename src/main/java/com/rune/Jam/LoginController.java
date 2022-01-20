package com.rune.Jam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class LoginController{

    @GetMapping("/login")
    public String login ( Model model, String error) {
        if (error != null) {

    @GetMapping ("/login")
    public String login(Model model, String error) {
        if (error != null)

            model.addAttribute("error", "Your username and password is invalid");
            return error; 
        }
        else{
            return "login";
        }
        

    }
}
