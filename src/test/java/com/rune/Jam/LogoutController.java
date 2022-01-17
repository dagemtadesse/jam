
@Controller
public class LogoutController{
    @GetMapping("/logout");
    public String logout(Model model) {
        model.addAttribute("message", "You have been logged out successfully");
        return "login";
}
