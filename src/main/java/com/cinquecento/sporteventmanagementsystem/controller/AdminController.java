package com.cinquecento.sporteventmanagementsystem.controller;

import com.cinquecento.sporteventmanagementsystem.model.Event;
import com.cinquecento.sporteventmanagementsystem.model.Participant;
import com.cinquecento.sporteventmanagementsystem.service.EventsService;
import com.cinquecento.sporteventmanagementsystem.service.ParticipantsService;
import com.cinquecento.sporteventmanagementsystem.util.validators.EventValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    private final EventsService eventsService;
    private final ParticipantsService participantsService;
    private final EventValidator eventValidator;

    @Autowired
    public AdminController(EventsService eventsService, ParticipantsService participantsService, EventValidator eventValidator) {
        this.eventsService = eventsService;
        this.participantsService = participantsService;
        this.eventValidator = eventValidator;
    }

    @GetMapping()
    public String adminPage() {return "admin/adminPage"; }

    @GetMapping("/eventRegistration")
    public String eventRegistration(@ModelAttribute("event") Event event) { return "admin/eventRegistration"; }

    @PostMapping("/eventRegistration")
    public String performEventRegistration(@ModelAttribute("event") @Valid Event event,
                                           BindingResult bindingResult) {

        eventValidator.validate(event, bindingResult);
        if(bindingResult.hasErrors()) {
            return "admin/eventRegistration";
        }

        eventsService.save(event);
        return "redirect:/admin";
    }

    @GetMapping("/showAllParticipants")
    public String showAllParticipants(Model model) {
        List<Participant> participants = participantsService.findAll().stream().filter(participant ->
                participant.getRole().equals("ROLE_USER")).collect(Collectors.toList());

        model.addAttribute("participants", participants);
        return "admin/participants";
    }

    @GetMapping("/participantInfo/{id}")
    public String showParticipant(@PathVariable("id") int id,
                                  Model model) {
        Optional<Participant> participant = participantsService.findById(id);
        model.addAttribute("participant", participant.get());
        return "admin/participantInfo";
    }

}
