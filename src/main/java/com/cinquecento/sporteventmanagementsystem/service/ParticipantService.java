package com.cinquecento.sporteventmanagementsystem.service;

import com.cinquecento.sporteventmanagementsystem.model.Participant;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {

    List<Participant> findAll();

    Optional<Participant> findById(int id);

    void update(int id, Participant updatedParticipant);

    void save(Participant participant);

    void delete(Participant participant);
}
