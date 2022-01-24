package com.rune.Jam.controllers;

import com.rune.Jam.models.RegistrationForm;
import com.rune.Jam.models.User;
import com.rune.Jam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class RegisterController{

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping ("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("newUser", new RegistrationForm());
        return "final/registration";
    }

    @PostMapping("/register")
    public String createNewUser(@Valid RegistrationForm newUser, Errors errors){
        log.info("processing new User" + newUser);
        if (errors.hasErrors()){
            log.info("validation errors: " + errors);
            return "final/registration";
        }

        var user = newUser.toUser(passwordEncoder);
        log.info("Tobe create User: " + user);
        repository.save(user);

        return "redirect:/login";
    }
}