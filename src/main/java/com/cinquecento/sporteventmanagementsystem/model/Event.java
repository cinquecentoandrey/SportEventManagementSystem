package com.cinquecento.sporteventmanagementsystem.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.security.AllPermission;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Event")
public class Event {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @Column(name = "event_name")
    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 32, message = "Event name should be between 1 and 32 symbols.")
    private String eventName;

    @Column(name = "university_name")
    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 64, message = "University name should be between 1 and 64 symbols.")
    private String universityName;

    @Column(name = "event_location")
    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 32, message = "Location should be between 1 and 32 symbols.")
    private String eventLocation;

    @Column(name = "event_date")
    @NotEmpty(message = "Field should not be empty.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String eventDate;

    @Column(name = "first_place_prize")
    @NotEmpty(message = "Field should not be empty.")
    @Min(value = 0, message = "The minimum value must be greater than or equal to 0")
    private double firstPlacePrize;

    @Column(name = "second_place_prize")
    @NotEmpty(message = "Field should not be empty.")
    @Min(value = 0, message = "The minimum value must be greater than or equal to 0")
    private double secondPlacePrize;

    @Column(name = "third_place_prize")
    @NotEmpty(message = "Field should not be empty.")
    @Min(value = 0, message = "The minimum value must be greater than or equal to 0")
    private double thirdPlacePrize;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "Event_Participant",
            joinColumns = {@JoinColumn(name = "event_id")},
            inverseJoinColumns = {@JoinColumn(name = "participant_id")})
    private Set<Participant> participants = new HashSet<>();
    public Event() {}

    public Event(String eventName, String universityName, String eventLocation, String eventDate, double firstPlacePrize, double secondPlacePrize, double thirdPlacePrize) {
        this.eventName = eventName;
        this.universityName = universityName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
        this.firstPlacePrize = firstPlacePrize;
        this.secondPlacePrize = secondPlacePrize;
        this.thirdPlacePrize = thirdPlacePrize;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public double getFirstPlacePrize() {
        return firstPlacePrize;
    }

    public void setFirstPlacePrize(double firstPlacePrize) {
        this.firstPlacePrize = firstPlacePrize;
    }

    public double getSecondPlacePrize() {
        return secondPlacePrize;
    }

    public void setSecondPlacePrize(double secondPlacePrize) {
        this.secondPlacePrize = secondPlacePrize;
    }

    public double getThirdPlacePrize() {
        return thirdPlacePrize;
    }

    public void setThirdPlacePrize(double thirdPlacePrize) {
        this.thirdPlacePrize = thirdPlacePrize;
    }

    public Set<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participant> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", universityName='" + universityName + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", firstPlacePrize=" + firstPlacePrize +
                ", secondPlacePrize=" + secondPlacePrize +
                ", thirdPlacePrize=" + thirdPlacePrize +
                ", participants=" + participants +
                '}';
    }
}
