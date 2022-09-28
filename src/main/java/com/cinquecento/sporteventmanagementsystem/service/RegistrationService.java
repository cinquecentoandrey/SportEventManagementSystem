package com.cinquecento.sporteventmanagementsystem.service;

import com.cinquecento.sporteventmanagementsystem.model.Participant;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {

    void register(Participant participant);

}
