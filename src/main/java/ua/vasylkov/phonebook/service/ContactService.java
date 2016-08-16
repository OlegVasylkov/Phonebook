package ua.vasylkov.phonebook.service;

import ua.vasylkov.phonebook.model.Contact;
import ua.vasylkov.phonebook.unit.exception.NotFoundException;

import java.util.Collection;

/**
 * Created by OlegVasylkov on 08.08.2016.
 */
public interface ContactService {
    Contact get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    Contact update(Contact contact, int userId) throws NotFoundException;

    Contact save(Contact contact, int userId);

    Collection<Contact> getAll(int userId);

    Collection<Contact> getFiltered(String search, int userId);
}