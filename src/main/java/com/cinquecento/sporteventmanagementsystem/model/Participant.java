package com.cinquecento.sporteventmanagementsystem.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Participant")
public class Participant {

    @Id
    @Column(name = "participant_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int participantId;

    @Column(name = "name")
    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 64, message = "Name should be between 1 and 64 symbols.")
    private String name;

    @Column(name = "age")
    @NotNull(message = "Field should not be empty.")
    @Min(value = 16, message = "Age should be greater than 16.")
    @Max(value = 100, message = "Age should be less than 100.")
    private int age;

    @Column(name = "date_of_birth")
    @NotNull(message = "Field should not be empty.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateOfBirth;

    @Column(name = "gender")
    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 16, message = "Gender should be between 1 and 16 symbols.")
    private String gender;

    @Column(name = "telephone")
    @NotEmpty(message = "Field should not be empty.")
    @Pattern(regexp = "^(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}$",
             message = "Correct format: +79855310868 | +7 (926) 777-77-77 | 89855310868")
    private String telephone;

    @Column(name = "email")
    @NotEmpty(message = "Field should not be empty.")
    @Size(max = 32, message = "Email must not exceed 32 characters.")
    @Email
    private String email;

    @Column(name = "university_name")
    @NotEmpty(message = "Field should not be empty.")
    @Size(min = 1, max = 64, message = "University name should be between 1 and 64 symbols.")
    private String universityName;

    @Column(name = "username")
    @NotEmpty(message = "Field should not be empty.")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "Field should not be empty.")
    private String password;

    public Participant() {}

    public Participant(String name, int age, String dateOfBirth, String gender, String telephone, String email, String universityName, String username) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.telephone = telephone;
        this.email = email;
        this.universityName = universityName;
        this.username = username;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", universityName='" + universityName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
