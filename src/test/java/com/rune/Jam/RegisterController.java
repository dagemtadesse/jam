
@Controller
public class RegisterController{
    @GetMapping("/register");
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
     
        return "register";
}
}
