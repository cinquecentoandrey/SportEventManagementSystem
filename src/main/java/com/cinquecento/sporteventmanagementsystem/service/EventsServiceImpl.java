package com.cinquecento.sporteventmanagementsystem.service;

import com.cinquecento.sporteventmanagementsystem.model.Event;
import com.cinquecento.sporteventmanagementsystem.model.Participant;
import com.cinquecento.sporteventmanagementsystem.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EventsServiceImpl implements EventService{

    private final EventsRepository eventsRepository;

    @Autowired
    public EventsServiceImpl(EventsRepository eventsRepository) {
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
    public void save(Event event) {
        eventsRepository.save(event);
    }

    @Transactional
    public void addParticipant(int id, Participant participant) {
        Optional<Event> event = eventsRepository.findById(id);
        if(event.isPresent()) {
            event.get().getParticipants().add(participant);
            participant.getEvents().add(event.get());
            eventsRepository.save(event.get());
        }
    }

    @Transactional
    public void delete(Event event) {
        eventsRepository.delete(event);
    }
}
