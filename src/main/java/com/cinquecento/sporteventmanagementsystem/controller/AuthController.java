package com.cinquecento.sporteventmanagementsystem.controller;

import com.cinquecento.sporteventmanagementsystem.model.Participant;
import com.cinquecento.sporteventmanagementsystem.service.RegistrationService;
import com.cinquecento.sporteventmanagementsystem.util.validators.ParticipantValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final ParticipantValidator participantValidator;
    private final RegistrationService registrationService;

    @Autowired
    public AuthController(ParticipantValidator participantValidator, RegistrationService registrationService) {
        this.participantValidator = participantValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String login() { return "auth/login"; }


    @GetMapping("/registration")
    public String registration(@ModelAttribute("participant") Participant participant) { return "auth/registration"; }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("participant") @Valid Participant participant,
                                      BindingResult bindingResult) {
        participantValidator.validate(participant, bindingResult);
        if(bindingResult.hasErrors()) {
            return "auth/registration";
        }

        registrationService.register(participant);
        return "redirect:/auth/login" ;
    }
}
