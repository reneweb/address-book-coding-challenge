package com.github.reneweb;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {
    private String addressBookFilePath = "AddressBook";

    @Test //readAddressBookFromFile
    public void shouldReadTheAddressBookFile() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        assertTrue(addressBook.getEntries().size() == 5);
    }

    @Test //getEntriesByFullName
    public void shouldReturnMatchingEntriesByFullName() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.getEntriesByFullName("Bill", "McKnight");
        assertTrue(entries.size() == 1);
    }

    @Test //getEntriesByFullName
    public void shouldReturnMatchingEntriesByFirstNameIfOnlyFirstNameGiven() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.getEntriesByFullName("Bill", null);
        assertTrue(entries.size() == 1);
    }

    @Test //getEntriesByFullName
    public void shouldReturnMatchingEntriesByLastNameIfOnlyLastNameGiven() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.getEntriesByFullName(null, "McKnight");
        assertTrue(entries.size() == 1);
    }

    @Test //getEntriesByFullName
    public void shouldReturnAllEntriesIfNoNameIsGiven() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.getEntriesByFullName(null, null);
        assertTrue(entries.size() == 5);
    }

    @Test //getEntriesByFirstName
    public void shouldReturnMatchingEntriesByFirstName() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.getEntriesByFirstName("Bill");
        assertTrue(entries.size() == 1);
    }

    @Test //getEntriesByLastName
    public void shouldReturnMatchingEntriesByLastName() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.getEntriesByLastName("McKnight");
        assertTrue(entries.size() == 1);
    }

    @Test //filterByGender
    public void shouldReturnEntriesOfGivenGender() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.filterByGender(AddressBookEntry.Gender.MALE);
        assertTrue(entries.size() == 3);
    }

    @Test //getOldestPerson
    public void shouldReturnOldestPerson() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        AddressBookEntry entry = addressBook.getOldestPerson();
        assertTrue(entry.getFirstName().equals("Wes") && entry.getLastName().equals("Jackson"));
    }

    @Test //searchAddressBook
    public void shouldSearchAddressBookByPredicate() throws Exception {
        AddressBook addressBook = AddressBook.readAddressBookFromFile(addressBookFilePath);
        List<AddressBookEntry> entries = addressBook.searchAddressBook(entry -> entry.getFirstName().equals("Wes"));
        assertTrue(entries.size() == 1);
        assertTrue(entries.get(0).getFirstName().equals("Wes"));
    }
}