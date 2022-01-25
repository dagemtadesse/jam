package com.rune.Jam.controllers;

import com.rune.Jam.models.ChangePasswordForm;
import com.rune.Jam.models.ChannelForm;
import com.rune.Jam.models.ProfileForm;
import com.rune.Jam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProfileController {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    @GetMapping("/profile")
    public String showProfile(Model model, Authentication authentication){
        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);

        model.addAttribute("user", user);
        return "final/userProfile";
    }

    @GetMapping("/editProfile")
    public String editProfile(Model model, Authentication authentication,
                              ChangePasswordForm changePasswordForm, ProfileForm profileForm){

        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);

        model.addAttribute("user", user);
        return "final/editProfile";
    }

    @PostMapping("/editProfile")
    public String editProfile(@Valid ProfileForm profileForm, BindingResult bindingResult,
                              @ModelAttribute ChangePasswordForm changePasswordForm, Authentication authentication, Model model){

        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);

        log.info("user@editProfile -XXX" + profileForm);

        if(bindingResult.hasErrors()){
            log.info("Error-XXX happened: " + bindingResult.getAllErrors());
            model.addAttribute("user", user);
            return "final/editProfile";
        }

        user.setFullName(profileForm.getFullName());
        user.setEmail(profileForm.getEmail());
        user.setAddress(profileForm.getAddress());


        userRepo.save(user);
        return "redirect:/profile";
    }

    @PostMapping("/changePassword")
    public String changePassword(@Valid ChangePasswordForm changePasswordForm, BindingResult bindingResult,
                                 @ModelAttribute ProfileForm profileForm, Authentication authentication, Model model){
        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);

        if(bindingResult.hasErrors()){
            model.addAttribute("user", user);

            return "final/editProfile";
        }

        var encodedPassword = encoder.encode(changePasswordForm.getNewPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);
        return "redirect:/profile";
    }
}
