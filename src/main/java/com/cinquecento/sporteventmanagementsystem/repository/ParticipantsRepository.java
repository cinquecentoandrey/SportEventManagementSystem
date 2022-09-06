package com.cinquecento.sporteventmanagementsystem.repository;

import com.cinquecento.sporteventmanagementsystem.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParticipantsRepository extends JpaRepository<Participant, Integer> {
    Optional<Participant> findByUsername(String username);

}
