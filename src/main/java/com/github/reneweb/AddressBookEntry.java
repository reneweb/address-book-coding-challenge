package com.github.reneweb;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by Rene on 27.08.2014.
 */
public class AddressBookEntry {
    public enum Gender {
        MALE,
        FEMALE
    }

    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dob;

    public AddressBookEntry(String firstName, String lastName, Gender gender, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
    }

    public Period ageDifferenceFrom(AddressBookEntry from) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //----- Getters and Setters -----
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
