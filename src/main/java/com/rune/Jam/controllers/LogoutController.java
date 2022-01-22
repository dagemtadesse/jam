package com.rune.Jam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class LogoutController{
    @GetMapping ("/logout")

    public String logout(Model model) {
        model.addAttribute("message", "You have been logged out successfully");
        return "login";
    }
}
