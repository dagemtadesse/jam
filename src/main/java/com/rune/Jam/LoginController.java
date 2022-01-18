package com.rune.Jam;

@Controller
public class LoginController{

    @GetMapping("/login")
    public String login(Model model, String error,) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid");
        else{
            return "login";
        }
            

    }
}
