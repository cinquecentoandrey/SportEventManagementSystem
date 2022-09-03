package com.cinquecento.sporteventmanagementsystem.util.validators;

import com.cinquecento.sporteventmanagementsystem.model.Participant;
import com.cinquecento.sporteventmanagementsystem.repository.ParticipantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.servlet.http.Part;

@Component
public class ParticipantValidator implements Validator {

    private final ParticipantsRepository participantsRepository;

    @Autowired
    public ParticipantValidator(ParticipantsRepository participantsRepository) {
        this.participantsRepository = participantsRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Participant.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Participant participant = (Participant) target;

        if(participantsRepository.findById(participant.getParticipantId()).isPresent()) {
            errors.rejectValue("email", "", "This email is already taken.");
        }
    }
}
