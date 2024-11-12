package com.tidz.leRev.model;

import jakarta.persistence.*;

import java.time.Year;

@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_year")
    private String lastName;
    @Column(name = "birth_year")
    private Year birthYear;
    @Column(name = "email")
    private String email;

    public Owner() {

    }

    public Owner(String firstName, String lastName, Year birthYear, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Year getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Year birthYear) {
        this.birthYear = birthYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
