package ua.vasylkov.phonebook.unit;

import ua.vasylkov.phonebook.model.Contact;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by OlegVasylkov on 15.07.2016.
 */
public class ContactUnit {
    public static final List<Contact> CONTACT_LIST = Arrays.asList(
            new Contact("Stivenson", "Bob", "Y", "+380987654321", "", "", ""),
            new Contact("Bond", "Mikle", "L", "+380999999223", "", "", ""),
            new Contact("Maas", "Ryan", "Z", "+380931234567", "", "", "")
    );

    public static void main(String[] args) {
        getFilteredByName(CONTACT_LIST, "on");
        getFilteredByPhone(CONTACT_LIST, "23");
    }

    public static List<Contact> getFilteredByPhone(Collection<Contact> contacts, String phone) {
        return contacts.stream()
                .filter(c -> c.getFirstName().concat(c.getLastName()).concat(c.getMiddleName()).contains(phone))
                .collect(Collectors.toList());
    }

    public static List<Contact> getFilteredByName(Collection<Contact> contacts, String name) {
        return contacts.stream()
                .filter(c -> c.getFirstName().concat(c.getLastName()).concat(c.getMiddleName()).contains(name))
                .collect(Collectors.toList());
    }

    public static List<Contact> getFiltered(Collection<Contact> contacts, String name){
        return contacts.stream()
                .filter(c -> c.getFirstName()
                        .concat(" ")
                        .concat(c.getLastName())
                        .concat(" ")
                        .concat(c.getMiddleName())
                        .concat(" ")
                        .concat(c.getMobilePhone())
                        .concat(" ")
                        .concat(c.getHomePhone()).contains(name))
                .collect(Collectors.toList());
    }

    public static String toString(String phoneNumber) {
        return phoneNumber.substring(0, 3) + "(" + phoneNumber.substring(3, 6) + ")" + phoneNumber.substring(6);
    }
}