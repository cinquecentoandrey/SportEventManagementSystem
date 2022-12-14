package com.cinquecento.sporteventmanagementsystem.service;

import com.cinquecento.sporteventmanagementsystem.model.Event;
import com.cinquecento.sporteventmanagementsystem.model.Participant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EventService {

    List<Event> findAll();

    Optional<Event> findById(int id);

    void update(int id, Event updatedEvent);

    void save(Event event);

    void addParticipant(int id, Participant participant);

    void delete(Event event);
}
