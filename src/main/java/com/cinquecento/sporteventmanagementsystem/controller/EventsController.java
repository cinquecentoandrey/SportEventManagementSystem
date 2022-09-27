package com.cinquecento.sporteventmanagementsystem.controller;

import com.cinquecento.sporteventmanagementsystem.model.Event;
import com.cinquecento.sporteventmanagementsystem.model.Participant;
import com.cinquecento.sporteventmanagementsystem.security.ParticipantsDetails;
import com.cinquecento.sporteventmanagementsystem.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/events")
public class EventsController {

    private final EventsService eventsService;

    @Autowired
    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping()
    public String index() {return "event/index";}

    @GetMapping("/showAll")
    public String showAll(Model model) {
        List<Event> events = eventsService.findAll();
        model.addAttribute("events", events);
        return "event/index";
    }

    @PostMapping("/registrationOnEvent/{id}")
    public String registrationOnEvent(@PathVariable("id") int id,
                                      Model model) {
        Authentication authentication = SecurityContextHolder.getContext().
                getAuthentication();
        ParticipantsDetails participantsDetails = (ParticipantsDetails) authentication.getPrincipal();
        Participant participant = participantsDetails.getParticipant();

        eventsService.addParticipant(id, participant);

        model.addAttribute("participant", participant);
        return "participant/info";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id,
                           Model model) {
        model.addAttribute("event", eventsService.findById(id).get());
        return "event/show";
    }
}
