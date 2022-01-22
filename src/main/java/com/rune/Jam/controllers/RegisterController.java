package com.rune.Jam.controllers;

import com.rune.Jam.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class RegisterController{
    
    @GetMapping ("/register")
    
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
}
}