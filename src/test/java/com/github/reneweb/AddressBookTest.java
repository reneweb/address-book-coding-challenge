package com.github.reneweb;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {
    private String addressBookFilePath = "AddressBook";

    @Test
    public void testReadAddressBookFromFile() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        assertTrue(addressBook.getEntries().size() == 5);
    }

    @Test
    public void testGetEntriesByFullName() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.getEntriesByFullName("Bill", "McKnight");
        assertTrue(entries.size() == 1);
    }

    @Test
    public void testGetEntriesByFirstName() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.getEntriesByFirstName("Bill");
        assertTrue(entries.size() == 1);
    }

    @Test
    public void testGetEntriesByLastName() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.getEntriesByLastName("McKnight");
        assertTrue(entries.size() == 1);
    }

    @Test
    public void testFilterByGender() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.filterByGender(AddressBookEntry.Gender.MALE);
        assertTrue(entries.size() == 3);
    }

    @Test
    public void testGetOldestPerson() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        AddressBookEntry entry = addressBook.getOldestPerson();
        assertTrue(entry.getFirstName().equals("Wes") && entry.getLastName().equals("Jackson"));
    }

    @Test
    public void testSearchAddressBook() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.searchAddressBook(entry -> entry.getFirstName().equals("Wes"));
        assertTrue(entries.size() == 1);
        assertTrue(entries.get(0).getFirstName().equals("Wes"));
    }
}