package com.rune.Jam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class RegisterController{
    @GetMapping ("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
     
        return "register";
}
}
