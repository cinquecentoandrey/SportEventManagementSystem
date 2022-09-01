package com.cinquecento.sporteventmanagementsystem.service;

import com.cinquecento.sporteventmanagementsystem.model.Event;
import com.cinquecento.sporteventmanagementsystem.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EventsService {

    private final EventsRepository eventsRepository;

    @Autowired
    public EventsService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public List<Event> findAll() {
        return eventsRepository.findAll();
    }

    public Optional<Event> findById(int id) {
        return eventsRepository.findById(id);
    }

    @Transactional
    public void update(int id, Event updatedEvent) {
        updatedEvent.setEventId(id);
        eventsRepository.save(updatedEvent);
    }

    @Transactional
    public void add(Event event) {
        eventsRepository.save(event);
    }

    @Transactional
    public void delete(Event event) {
        eventsRepository.delete(event);
    }
}
