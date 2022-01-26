package com.rune.Jam.controllers;

import com.rune.Jam.models.Channel;
import com.rune.Jam.models.ChannelForm;
import com.rune.Jam.models.ProfileForm;
import com.rune.Jam.repositories.ChannelRepository;
import com.rune.Jam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ChannelController {

    private final UserRepository userRepo;
    private final ChannelRepository chanRepo;

    @GetMapping("/addChannel")
    public String addChanel(Model model, Authentication authentication, ChannelForm chanelForm){
        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);

        model.addAttribute("user", user);
        return "final/addCompany";
    }

    @GetMapping("/editChannel")
    public String editChanel(Model model, Authentication authentication, ChannelForm chanelForm){
        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);

        model.addAttribute("user", user);
        return "final/editCompany";
    }

    @PostMapping("/editChannel")
    public String editChannel(@Valid ChannelForm channelForm,BindingResult bindingResult,
                              Authentication authentication , Model model
                            ) {

        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);
        var channel = chanRepo.findById(channelForm.getId());

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "final/editCompany";
        }

        if(channel.isPresent() && channel.get().getCreator().getId() == user.getId()) {
            var editChannel = channel.get();
            editChannel.setName(channelForm.getName());
            editChannel.setAddress(channelForm.getAddress());
            editChannel.setDescription(channelForm.getDescription());
            editChannel.setEmail(channelForm.getEmail());

            chanRepo.save(editChannel);
        }

        return "redirect:/profile";
    }

    @PostMapping("/createChannel")
    public String createChannel(@Valid ChannelForm channelForm, BindingResult bindingResult,
                                Authentication authentication, Model model) {

        var email = authentication.getName();
        var user = userRepo.findUserByEmail(email);

        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "final/addCompany";
        }

        var newChannel = channelForm.toChannel();
        newChannel.setCreator(user);
        chanRepo.save(newChannel);

        return "redirect:/profile";
    }
}

