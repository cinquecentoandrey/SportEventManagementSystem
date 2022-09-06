package com.cinquecento.sporteventmanagementsystem.controller;

import com.cinquecento.sporteventmanagementsystem.model.Participant;
import com.cinquecento.sporteventmanagementsystem.security.ParticipantsDetails;
import com.cinquecento.sporteventmanagementsystem.service.ParticipantsService;
import com.cinquecento.sporteventmanagementsystem.util.validators.ParticipantValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ParticipantController {

    private final ParticipantsService participantsService;
    private final ParticipantValidator participantValidator;

    @Autowired
    public ParticipantController(ParticipantsService participantsService, ParticipantValidator participantValidator) {
        this.participantsService = participantsService;
        this.participantValidator = participantValidator;
    }

    @GetMapping("/info")
    public String info(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().
                getAuthentication();
        ParticipantsDetails participantsDetails = (ParticipantsDetails) authentication.getPrincipal();
        Participant participant = participantsDetails.getParticipant();
        model.addAttribute("participant", participant);

        return "participant/info";
    }

    @GetMapping("/results")
    public String results() {
        return "participant/results";
    }
}
