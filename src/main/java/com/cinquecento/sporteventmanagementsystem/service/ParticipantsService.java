package com.cinquecento.sporteventmanagementsystem.service;

import com.cinquecento.sporteventmanagementsystem.model.Event;
import com.cinquecento.sporteventmanagementsystem.model.Participant;
import com.cinquecento.sporteventmanagementsystem.repository.ParticipantsRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ParticipantsService {

    private final ParticipantsRepository participantsRepository;

    @Autowired
    public ParticipantsService(ParticipantsRepository participantsRepository) {
        this.participantsRepository = participantsRepository;
    }

    public List<Participant> findAll() {
        return participantsRepository.findAll();
    }

    public Optional<Participant> findById(int id) {
        return participantsRepository.findById(id);
    }

    @Transactional
    public void update(int id, Participant updatedParticipant) {
        updatedParticipant.setParticipantId(id);
        participantsRepository.save(updatedParticipant);
    }

    @Transactional
    public void add(Participant participant) {
        participantsRepository.save(participant);
    }

    @Transactional
    public void delete(Participant participant) {
        participantsRepository.delete(participant);
    }
}
