package com.cinquecento.sporteventmanagementsystem.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class EventDTO {

    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 32, message = "Sport name should be between 1 and 32 symbols.")
    private String sportName;

    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 32, message = "University name should be between 1 and 32 symbols.")
    private String universityName;

    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 32, message = "Location should be between 1 and 32 symbols.")
    private String location;

    private Date date;

    @NotEmpty(message = "Field should not be empty.")
    @Min(value = 0, message = "The minimum value must be greater than or equal to 0")
    private double firstPlacePrize;

    @NotEmpty(message = "Field should not be empty.")
    @Min(value = 0, message = "The minimum value must be greater than or equal to 0")
    private double secondPlacePrize;

    @NotEmpty(message = "Field should not be empty.")
    @Min(value = 0, message = "The minimum value must be greater than or equal to 0")
    private double thirdPlacePrize;

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
