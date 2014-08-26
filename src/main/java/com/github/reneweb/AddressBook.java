package com.github.reneweb;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Rene on 27.08.2014.
 */
public class AddressBook {
    public List<AddressBookEntry> entries = new ArrayList<AddressBookEntry>();

    public static AddressBook readAddressBookFromFile() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<AddressBookEntry> getEntriesByFullName(String firstName, String lastName) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<AddressBookEntry> getEntriesByFirstName(String firstName) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<AddressBookEntry> getEntriesByLastName(String lastName) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<AddressBookEntry> filterByGender(AddressBookEntry.Gender gender) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public AddressBookEntry getOldestPerson() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public List<AddressBookEntry> searchAddressBook(Predicate<AddressBook> predicate) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
