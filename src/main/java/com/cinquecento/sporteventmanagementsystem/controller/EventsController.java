package com.cinquecento.sporteventmanagementsystem.controller;

import com.cinquecento.sporteventmanagementsystem.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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

    @GetMapping("/show")
    public void show() {
        eventsService.findAll();
    }

}
