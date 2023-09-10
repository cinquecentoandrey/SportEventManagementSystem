package com.cinquecento.eventmanagementsystem.repository;

import com.cinquecento.eventmanagementsystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventsRepository extends JpaRepository<Event, Integer> {
    Optional<Event> findByEventName(String eventName);

    @Query(value = "SELECT E.*\n" +
            "FROM event_participant AS EP\n" +
            "JOIN Event AS E ON EP.participant_id = :id", nativeQuery = true)
    List<Event> findAllByParticipantId(@Param("id") int id);

}
