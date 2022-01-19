package com.rune.Jam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.ui.Model;

@Controller
public class LogoutController{

    @GetMapping("/logout")
=======

@Controller
public class LogoutController{
    @GetMapping ("/logout")
>>>>>>> 324b99530ccc9f22455d6ba6a3c9204dcfdf36ac
    public String logout(Model model) {
        model.addAttribute("message", "You have been logged out successfully");
        return "login";
    }
}
