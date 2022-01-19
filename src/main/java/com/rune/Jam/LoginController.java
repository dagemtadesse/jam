package com.rune.Jam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.ui.Model;
=======


>>>>>>> 324b99530ccc9f22455d6ba6a3c9204dcfdf36ac

@Controller
public class LoginController{

<<<<<<< HEAD
    @GetMapping("/login")
    public String login ( Model model, String error) {
        if (error != null) {
=======
    @GetMapping ("/login")
    public String login(Model model, String error) {
        if (error != null)
>>>>>>> 324b99530ccc9f22455d6ba6a3c9204dcfdf36ac
            model.addAttribute("error", "Your username and password is invalid");
            return error; 
        }
        else{
            return "login";
        }
        

    }
}
