package com.rune.Jam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD

=======
>>>>>>> 324b99530ccc9f22455d6ba6a3c9204dcfdf36ac
@Controller
public class HomeController {
    @GetMapping ("/")
    public String home(){
        return "home";
    }
    
}
