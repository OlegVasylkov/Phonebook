package ua.vasylkov.phonebook.repository;

import ua.vasylkov.phonebook.model.Contact;

import java.util.Collection;

/**
 * Created by OlegVasylkov on 05.08.2016.
 */
public interface ContactRepository {
    Contact save(Contact contact, int userId);

    boolean delete(int id, int userId);

    Contact get(int id, int userId);

    Collection<Contact> getAll(int userId);

    Collection<Contact> getFiltered(String name, int userId);
}
