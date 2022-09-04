package com.cinquecento.sporteventmanagementsystem.service;

import com.cinquecento.sporteventmanagementsystem.model.Participant;
import com.cinquecento.sporteventmanagementsystem.repository.ParticipantsRepository;
import com.cinquecento.sporteventmanagementsystem.security.ParticipantsDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParticipantDetailsService implements UserDetailsService {

    private final ParticipantsRepository participantsRepository;

    @Autowired
    public ParticipantDetailsService(ParticipantsRepository participantsRepository) {
        this.participantsRepository = participantsRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Participant> participant = participantsRepository.findByUsername(username);

        if(participant.isEmpty()){
            throw new UsernameNotFoundException("User not found.");
        }

        return new ParticipantsDetails(participant.get());
    }
}
