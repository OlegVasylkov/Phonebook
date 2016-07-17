package Unit;

import model.Contact;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by filipenko_n on 15.07.2016.
 */
public class ContactUnit {
    public static void main(String[] args) {
        List<Contact> contacts = Arrays.asList(
                new Contact("Stivenson", "Bob", "Y", "+380987654321"),
                new Contact("Bond", "Mikle", "L", "+380999999223"),
                new Contact("Maas", "Ryan", "Z", "+380931234567")
                );
        getFilteredByName(contacts, "on");
        getFilteredByPhone(contacts, "23");
    }

    public static List<Contact> getFilteredByPhone(List<Contact> contacts, String phone) {
        return contacts.stream()
                .filter(c -> c.getFirstName().concat(c.getLastName()).concat(c.getMiddleName()).contains(phone))
                .collect(Collectors.toList());
    }

    public static List<Contact> getFilteredByName(List<Contact> contacts, String name) {
        return contacts.stream()
                        .filter(c -> c.getFirstName().concat(c.getLastName()).concat(c.getMiddleName()).contains(name))
                        .collect(Collectors.toList());
    }
}
