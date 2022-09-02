package com.cinquecento.sporteventmanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/participant")
public class ParticipantController {

    @GetMapping("/login")
    public String login() {return "participants/participantLogin";}

}
