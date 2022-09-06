package com.cinquecento.sporteventmanagementsystem.repository;

import com.cinquecento.sporteventmanagementsystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventsRepository extends JpaRepository<Event, Integer> {
    Optional<Event> findByEventName(String eventName);

}
