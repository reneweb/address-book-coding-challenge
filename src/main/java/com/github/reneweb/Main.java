package com.github.reneweb;

import java.io.IOException;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;

/**
 * Created by Rene on 27.08.2014.
 */
public class Main {
    public static void main(String[] args) {
        try {
            AddressBook addressBook = AddressBook.readAddressBookFromFile("AddressBook");

            answerQuestionOne(addressBook);
            answerQuestionTwo(addressBook);
            answerQuestionThree(addressBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void answerQuestionOne(AddressBook addressBook) {
        //1. How many males are in the address book?
        List<AddressBookEntry> maleEntries = addressBook.filterByGender(AddressBookEntry.Gender.MALE);
        System.out.println("1. How many males are in the address book?");
        System.out.println(String.format("There are %s males in the address book.", maleEntries.size()));
        System.out.println();
    }

    public static void answerQuestionTwo(AddressBook addressBook) {
        //2. Who is the oldest person in the address book?
        AddressBookEntry oldestPerson = addressBook.getOldestPerson();
        System.out.println("2. Who is the oldest person in the address book?");
        System.out.println(String.format(
                "%s %s is the oldest person in the address book.",
                oldestPerson.getFirstName(),
                oldestPerson.getLastName()));
        System.out.println();
    }

    public static void answerQuestionThree(AddressBook addressBook) {
        //3. How many days older is Bill than Paul?
        AddressBookEntry bill = addressBook.getEntriesByFirstName("Bill").get(0);
        AddressBookEntry paul = addressBook.getEntriesByFirstName("Paul").get(0);
        Period ageDifference = bill.periodBetweenDob(paul);

        System.out.println("3. How many days older is Bill than Paul?");
        System.out.println(String.format(
                "%s %s is %s days, %s months and %s years (%s days overall) older than %s %s.",
                bill.getFirstName(),
                bill.getLastName(),
                ageDifference.getDays(),
                ageDifference.getMonths(),
                ageDifference.getYears(),
                ChronoUnit.DAYS.between(bill.getDob(), paul.getDob()),
                paul.getFirstName(),
                paul.getLastName()));
    }
}
