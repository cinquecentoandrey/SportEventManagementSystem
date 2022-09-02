package com.cinquecento.sporteventmanagementsystem.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class ParticipantDTO {

    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 32, message = "Name should be between 1 and 32 symbols.")
    private String name;

    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 14, max = 120, message = "Фge must be between 14 and 120")
    private int age;

    @NotEmpty(message = "Field should not be empty.")
    private Date dateOfBirth;

    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 16, message = "Gender should be between 1 and 16 symbols.")
    private String gender;

    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 10, max = 10, message = "The telephone number must be 10 digits long.")
    private String telephone;

    @Email
    private String email;

    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 32, message = "University name should be between 1 and 32 symbols.")
    private String universityName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}