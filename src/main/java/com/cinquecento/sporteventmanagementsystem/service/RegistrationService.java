package com.cinquecento.sporteventmanagementsystem.service;

import com.cinquecento.sporteventmanagementsystem.model.Participant;
import com.cinquecento.sporteventmanagementsystem.repository.ParticipantsRepository;
import com.cinquecento.sporteventmanagementsystem.util.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RegistrationService {

    private final ParticipantsRepository participantsRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(ParticipantsRepository participantsRepository, PasswordEncoder passwordEncoder) {
        this.participantsRepository = participantsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Participant participant) {
        participant.setPassword(passwordEncoder.encode(participant.getPassword()));
        participant.setRole(String.valueOf(Role.ROLE_USER));
        participantsRepository.save(participant);
    }
}
