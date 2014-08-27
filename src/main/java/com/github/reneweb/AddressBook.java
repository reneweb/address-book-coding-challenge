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

    public List<AddressBookEntry> searchAddressBook(Predicate<AddressBookEntry> predicate) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //----- Getters and Setters -----
    public List<AddressBookEntry> getEntries() {
        return entries;
    }
}
