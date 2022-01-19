package com.rune.Jam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.ui.Model;


@Controller
public class RegisterController{
    @GetMapping("/register")
=======
@Controller
public class RegisterController{
    @GetMapping ("/register")
>>>>>>> 324b99530ccc9f22455d6ba6a3c9204dcfdf36ac
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
     
        return "register";
}
}
