package com.cinquecento.sporteventmanagementsystem.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Event")
public class Event {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @Column(name = "sport_name")
    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 32, message = "Sport name should be between 1 and 32 symbols.")
    private String sportName;

    @Column(name = "university_name")
    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 32, message = "University name should be between 1 and 32 symbols.")
    private String universityName;

    @Column(name = "location")
    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 32, message = "Location should be between 1 and 32 symbols.")
    private String location;

    @Column(name = "date")
    private Date date;

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

    public Event() {}

    public Event(String sportName, String universityName, String location, Date date, double firstPlacePrize, double secondPlacePrize, double thirdPlacePrize) {
        this.sportName = sportName;
        this.universityName = universityName;
        this.location = location;
        this.date = date;
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

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
