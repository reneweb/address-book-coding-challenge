package com.github.reneweb;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.Assert.*;

public class AddressBookEntryTest {

    @Test
    public void shouldReturnTheAgeDifference() throws Exception {
        AddressBookEntry firstEntry = new AddressBookEntry("Test", "Test", AddressBookEntry.Gender.MALE, LocalDate.of(1970, 1, 1));
        AddressBookEntry secondEntry = new AddressBookEntry("Test", "Test", AddressBookEntry.Gender.MALE, LocalDate.of(1980, 1, 1));
        Period ageDifference = firstEntry.ageDifferenceFrom(secondEntry);
        assertTrue(ageDifference.getDays() == 0 && ageDifference.getMonths() == 0 && ageDifference.getYears() == 10);
    }
}