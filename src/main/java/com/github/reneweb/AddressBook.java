package com.github.reneweb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Rene on 27.08.2014.
 */
public class AddressBook {
    private final List<AddressBookEntry> entries;

    private AddressBook(List<AddressBookEntry> entries) {
        this.entries = entries;
    }

    public static AddressBook readAddressBookFromFile(String path) throws IOException {
        Path p = Paths.get(path);
        try(Stream<String> lines = Files.lines(p)) {
            List<AddressBookEntry> entries = lines.map(AddressBook::parseLineFromAddressBook).collect(Collectors.toList());
            return new AddressBook(entries);
        }
    }

    private static AddressBookEntry parseLineFromAddressBook(String line) {
        List<String> parsedLine = Arrays.asList(line.split(",| "))
                .stream()
                .filter(e -> !e.isEmpty())
                .map(String::trim)
                .collect(Collectors.toList());


        return new AddressBookEntry(
                parsedLine.get(0),
                parsedLine.get(1),
                AddressBookEntry.getGenderFromString(parsedLine.get(2)),
                AddressBookEntry.getDateFromString(parsedLine.get(3)));
    }

    public List<AddressBookEntry> getEntriesByFullName(String firstName, String lastName) {
        if(firstName != null && lastName != null) {
            return entries.stream()
                    .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                    .collect(Collectors.toList());
        } else if(firstName != null) {
            return getEntriesByFirstName(firstName);
        } else if(lastName != null) {
            return getEntriesByLastName(lastName);
        } else {
            return getEntries();
        }
    }

    public List<AddressBookEntry> getEntriesByFirstName(String firstName) {
        return entries.stream()
                .filter(e -> e.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    public List<AddressBookEntry> getEntriesByLastName(String lastName) {
        return entries.stream()
                .filter(e -> e.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public List<AddressBookEntry> filterByGender(AddressBookEntry.Gender gender) {
        return entries.stream()
                .filter(e -> e.getGender() == gender)
                .collect(Collectors.toList());
    }

    public AddressBookEntry getOldestPerson() {
        return entries.stream()
                .min( (e1, e2) -> e1.getDob().compareTo(e2.getDob()))
                .get();
    }

    public List<AddressBookEntry> searchAddressBook(Predicate<AddressBookEntry> predicate) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //----- Getters and Setters -----
    public List<AddressBookEntry> getEntries() {
        return entries;
    }
}
