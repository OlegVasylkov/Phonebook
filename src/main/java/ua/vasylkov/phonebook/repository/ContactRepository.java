package ua.vasylkov.phonebook.repository;

import ua.vasylkov.phonebook.model.Contact;

import java.util.Collection;

/**
 * Created by OlegVasylkov on 05.08.2016.
 */
public interface ContactRepository {
    Contact save(Contact contact);

    void delete(int id);

    Contact get(int id);

    Collection<Contact> getAll();

}
